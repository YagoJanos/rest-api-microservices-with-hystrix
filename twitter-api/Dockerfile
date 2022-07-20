FROM openjdk:17-jdk-slim
MAINTAINER Yago Janos
COPY build/libs/*jar app.jar
ENV BEARER_TOKEN=PUT_YOUR_BEARER_TOKEN_HERE
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
