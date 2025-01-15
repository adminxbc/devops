pipeline {
    agent any

    environment{
        harborUser = 'admin'
        harborPasswd = 'Harbor12345'
        harborAddress = '192.168.1.133:80'
        harborRepo = 'repo'
    }

    stages {
        stage('gitee拉取代码') {
            steps {
               git 'https://github.com/adminxbc/devops.git'
            }
        }

        stage('maven打包') {
            steps {
               sh '/var/jenkins_home/maven/bin/mvn clean package  -DskipTests -Dmaven.test.skip=true'
            }
        }

        stage('sonar-scanner检查代码') {
            steps {
                echo 'sonar-scanner检查代码成功'
            }
        }

        stage('自定义 docker 镜像') {
            steps {
                sh '''mv target/*.jar ./docker/
                docker build -t ${JOB_NAME}:${tag}  ./docker/'''
            }
        }

        stage('自定义镜像上传harbor仓库') {
            steps {
                sh '''docker login -u ${harborUser} -p ${harborPasswd} ${harborAddress}
                docker tag ${JOB_NAME}:${tag}  ${harborAddress}/${harborRepo}/${JOB_NAME}:${tag} 
                docker push ${harborAddress}/${harborRepo}/${JOB_NAME}:${tag} '''
            }
        }

        stage('publish over ssh通知服务器拉取脚本文件') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'test', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 
"deploy.sh  $harborPasswd $harborRepo $JOB_NAME ${tag} $host_port $container_prot", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }

        stage('部署项目到k8s集群') {
            steps {
                echo '部署项目到k8s集群成功'
            }
        }
    }
}





