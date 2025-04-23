FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/libro-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]