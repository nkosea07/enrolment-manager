FROM openjdk:17-oracle
LABEL authors="nkosinxumalo"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=production","/app.jar"]