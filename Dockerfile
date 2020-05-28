# For Java 8, try this
# FROM openjdk:8-jdk-alpine
# Commands
# sudo docker build -t spring-datastax:1.0 .
# sudo docker run -d -p 8080:8080 -t spring-datastax:1.0
# docker run -p 8080:8080 -t spring-datastax:1.0

# docker-compose up -d --build --scale datastaxproduct=3
# docker-compose down

# For Java 11, try this
FROM adoptopenjdk/openjdk8:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/product-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

COPY creds.zip creds.zip

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]


