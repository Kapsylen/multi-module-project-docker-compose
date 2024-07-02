FROM maven:3.8.3-openjdk-17
LABEL maintainer="your-email@example.com"
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/producer-api.jar
ADD ${JAR_FILE} producer-api.jar
ENTRYPOINT ["java","-jar","/producer-api.jar"]