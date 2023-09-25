# Spring Boot Task Management Application

This is a Spring Boot application for managing tasks. It provides a RESTful API for creating, updating, and deleting tasks. Additionally, it includes Docker and Jenkins files for containerization and continuous integration.

## Features

- Create, update, and delete tasks.
- Retrieve a list of tasks.
- Task priority and due date management.

## Technologies Used

- **Spring Boot:** The application is built using the Spring Boot framework, which simplifies the development of Java-based applications.
- **Maven:** This project is built and managed using Maven, making it easy to manage dependencies and build the application.
- **Docker:** Docker files are included to containerize the application, allowing for easy deployment and scalability.
- **Docker Compose:** Docker Compose is used to define and run multi-container Docker applications.
- **Jenkins:** Jenkins files are included for setting up continuous integration and continuous deployment (CI/CD) pipelines.

## Getting Started

Follow these steps to get the application up and running:

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/sohitdeveloper/spring-boot-todo-docker
   ```

2. Build the Maven project:

   ```bash
   mvn clean install
   ```

3. Run the application using Maven:

   ```bash
   mvn spring-boot:run
   ```

4. Access the application at `http://localhost:8080` in your web browser.

## Dockerization

Docker files are included in this repository for containerizing the application. To build and run the Docker container, follow these steps:

1. Ensure you have Docker installed on your machine.

2. Build the Docker image:

   ```bash
   docker build -t task-be .
   ```

## Docker Compose

Docker Compose is used to manage the application and its dependencies as a multi-container Docker application. To run the application and its required services using Docker Compose:

1. Ensure you have Docker Compose installed on your machine.

2. Navigate to the project root directory containing the `docker-compose.yml` file.

3. Run the following command to start the application and its dependencies:

   ```bash
   docker-compose up
   ```

This will start the Spring Boot application and any other services defined in the `docker-compose.yml` file.

## Jenkins Integration

Jenkins files are included for setting up continuous integration and deployment pipelines. To set up Jenkins for this project:

1. Install Jenkins on your server or local machine.

2. Create a new Jenkins pipeline job and configure it to pull the project from your Git repository.

3. Use the provided `Jenkinsfile` to define the pipeline stages, including building and deploying the application.

4. Run the Jenkins job to trigger the pipeline.

## Contributing

If you would like to contribute to this project, please follow the standard Git workflow:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make your changes and commit them with clear, concise commit messages.

4. Push your branch to your fork.

5. Create a pull request to merge your changes into the main repository.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or issues, please feel free to contact the project maintainers:

- [Sohit Kumar](mailto:sohit.developer@gmail.com)

Thank you for using the Spring Boot Task Management Application!
