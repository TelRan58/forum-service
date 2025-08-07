FROM eclipse-temurin:21-jre-alpine

LABEL authors="edward"

WORKDIR /app

COPY ./target/forum-service-0.0.1-SNAPSHOT.jar ./forum-service.jar

ENV MONGODB_USER=user

ENV MONGODB_PASSWORD=""

ENV MONGODB_BASE=test

ENTRYPOINT ["java", "-jar", "/app/forum-service.jar"]