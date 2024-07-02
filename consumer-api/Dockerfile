FROM maven:3.8.3-openjdk-17
LABEL maintainer="your-email@example.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/consumer-api.jar
ADD ${JAR_FILE} consumer-api.jar
ENTRYPOINT ["java","-jar","/consumer-api.jar"]