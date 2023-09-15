# Use an official Maven image to build the application
FROM maven:3.8.3-openjdk-11 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Build the Spring Boot application and package it into a JAR file
RUN mvn clean package

# Create the final image with just the JAR file
FROM openjdk:11-jre-slim

WORKDIR /app

# Copy the JAR file from the builder stage to the final image
COPY --from=builder /app/target/todo-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your Spring Boot application listens on (e.g., 8090)
EXPOSE 8090

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]