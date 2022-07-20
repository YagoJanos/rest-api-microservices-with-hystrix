FROM openjdk:17-jdk-slim
MAINTAINER Yago Janos
COPY build/libs/*jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]