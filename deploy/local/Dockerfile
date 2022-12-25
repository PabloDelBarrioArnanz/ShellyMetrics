FROM openjdk:19-alpine
ARG JAR_FILE=ShellyMetrics-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]