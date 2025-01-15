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
               sh '/var/jenkins_home/maven/bin/mvn clean package  -DskipTests'
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
                docker build -t ${JOB_NAME}:v1.6  ./docker/'''
            }
        }

        stage('自定义镜像上传harbor仓库') {
            steps {
                sh '''docker login -u ${harborUser} -p ${harborPasswd} ${harborAddress}
                docker tag ${JOB_NAME}:v1.6  ${harborPasswd}/${harborRepo}/{JOB_NAME}:v1.6 
                docker push ${harborAddress}/${harborRepo/{JOB_NAME}:v1.6 '''
            }
        }

        stage('publish over ssh通知服务器拉取脚本文件') {
            steps {
                echo 'ssh通知服务器拉取脚本文件成功'
            }
        }

        stage('部署项目到k8s集群') {
            steps {
                echo '部署项目到k8s集群成功'
            }
        }
    }
}





