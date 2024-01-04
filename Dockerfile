FROM ubuntu:latest
LABEL authors="duong"

ENTRYPOINT ["top", "-b"]

# Build Stage
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY /Desktop/rest-services/pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn install -DskipTests
COPY /Desktop/rest-services/ .
RUN mvn package -DskipTests

# Run Stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
