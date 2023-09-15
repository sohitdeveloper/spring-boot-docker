# fetching latest version of Java
FROM openjdk:20

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/todo-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8090

# Starting the application
CMD ["java", "-jar", "todo-0.0.1-SNAPSHOT.jar"]