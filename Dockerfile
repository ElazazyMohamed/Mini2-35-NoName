FROM openjdk:25-ea-4-jdk-oraclelinux9

WORKDIR /app

COPY target/miniapp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
