FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /feedservice

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre-alpine

COPY --from=builder /feedservice/target/*.jar feedservice.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "feedservice.jar"]