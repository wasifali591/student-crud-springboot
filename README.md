
# Student CRUD Application with Spring Boot

This repository contains a backend application built using Spring Boot framework. The application focuses on managing student records through CRUD (Create, Read, Update, Delete) operations.

## Overview

This Spring Boot application provides RESTful APIs for managing student records in a PostgreSQL database. It does not include a user interface (UI) and is designed to be consumed by front-end applications or other services.

## Features

- **Create:** Add new student records to the database.
- **Read:** Retrieve existing student records from the database.
- **Update:** Modify the details of existing student records in the database.
- **Delete:** Remove unwanted student records from the database.

## Technologies Used

- **Spring Boot:** Framework for building Java applications.
- **Spring Data JPA:** Simplifies data access layer by providing repository support.
- **PostgreSQL:** Database management system used to store student records.

## Project Structure

The project follows a standard Maven project structure. Inside the `src/main/java/com/example/` directory, you'll find the following packages:

- `controller/`: Contains controller classes responsible for handling HTTP requests and responses.
- `repository/`: Provides interfaces that extend Spring Data JPA repository interfaces, enabling database operations.
- `service/`: Contains service classes implementing business logic for CRUD operations.
- `exception/`: Includes custom exception classes for handling errors in the application.
- `configurations/`: Contains configuration classes for Spring Boot application.
- `dtos/`: Includes Data Transfer Object (DTO) classes for transferring data between layers.
- `entities/`: Contains entity classes representing database tables.

## Testing

The application includes test cases to ensure the functionality of various components. Test cases are written using JUnit and Mockito frameworks.

- **JUnit:** Used for writing unit tests to verify the behavior of individual components.
- **Mockito:** Used for mocking dependencies and interactions during testing.

## Getting Started

To run this application locally, follow these steps:

1. Clone this repository to your local machine.
2. Make sure you have PostgreSQL installed and running.
3. Update the database configuration in `application.properties` file with your PostgreSQL credentials.
4. Build the project using Maven:

    ```
    mvn clean install
    ```

5. Run the application:

    ```
    mvn spring-boot:run
    ```

6. Access the RESTful APIs using a tool like Postman or by integrating them into your front-end application.

## API Endpoints

The following API endpoints are available:

- `GET /students`: Retrieve all student records.
- `GET /students/{id}`: Retrieve a specific student record by ID.
- `POST /students`: Create a new student record.
- `PUT /students/{id}`: Update an existing student record.
- `DELETE /students/{id}`: Delete a student record by ID.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, feel free to open an issue or submit a pull request.

