pipeline {
    agent any

    environment{
        key="value"
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

        stage('自定义镜像上传harbor仓库') {
            steps {
                echo '上传harbor仓库成功'
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





