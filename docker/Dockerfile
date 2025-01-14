# 基于官方的Java运行环境
#FROM daocloud.io/library/java:8u40-jdk
#openjdk:17
FROM openjdk:23
# 将工作目录设置为/app
WORKDIR /usr/local
# 将本地代码复制到工作目录内
COPY ./*.jar  /usr/local/test.jar
# 设置容器启动时运行的命令
CMD ["java", "-jar", "test.jar"]
