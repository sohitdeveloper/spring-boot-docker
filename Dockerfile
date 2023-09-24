# Stage 1: Build the application
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/task-api.jar task-api.jar
CMD ["java", "-jar", "task-api.jar"]