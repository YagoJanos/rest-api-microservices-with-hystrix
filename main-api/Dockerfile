FROM openjdk:17-jdk-slim
MAINTAINER Yago Janos
COPY build/libs/*jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]