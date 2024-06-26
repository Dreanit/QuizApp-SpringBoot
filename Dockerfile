# Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17.0.2-jdk-slim
WORKDIR /app
COPY --from=build /app/target/quizapp-0.0.1-SNAPSHOT.jar quizapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","quizapp.jar"]
