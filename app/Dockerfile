FROM openjdk:11-jre-slim
VOLUME /tmp
LABEL maintainer = "stkong@goqba.com"
ARG JAR_FILE=build/libs/app-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]