FROM ubuntu:latest
LABEL authors="duong"

ENTRYPOINT ["top", "-b"]

FROM maven:3.8.3-openjdk-17

WORKDIR /app

COPY pom.xml .

RUN mvn install -DskipTests

COPY . .

RUN mvn package

CMD ["java", "-jar", "target/rest-service-0.0.1.SNAPSHOT.jar"]