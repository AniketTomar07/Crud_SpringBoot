# CRUD-SpringBoot-API

## Introduction
This project is a Spring Boot application that manages projects with basic CRUD operations (Create, Read, Update, Delete). It utilizes Spring Web for RESTful API development, Spring Data JPA for data persistence, and an H2 in-memory database for storage.

## Project Setup
Follow these steps to set up and run the project:

1. **Clone the repository**:
git clone <repository-url>

2. **Navigate to the project directory**:
cd <project-directory>

3. **Build the project**:
./mvnw clean install

4. **Run the application**:
./mvnw spring-boot:run


5. **Access the application**:
Once the application is running, you can access it at [http://localhost:8080](http://localhost:8080).

## Database Configuration
The H2 in-memory database is configured in the `application.properties` file. No additional setup is required.

## Project Structure
The project follows a standard Spring Boot structure with the following packages:

- `com.example.project.controllers`: Contains controller classes to handle HTTP requests.
- `com.example.project.models`: Contains model classes representing entities (e.g., Project).
- `com.example.project.repositories`: Contains repository interfaces extending JpaRepository.
- `com.example.project.services`: Contains service classes to handle business logic.

## API Usage
The following endpoints are available for interacting with the project API:

1. **Create Project**: 
- URL: `POST /projects`
- Request Body: JSON object representing the project
- Example:
  ```json
  {
      "name": "Project Name",
      "description": "Project Description",
      "startDate": "2024-03-15",
      "endDate": "2024-12-31"
  }
  ```

2. **Get All Projects**: 
- URL: `GET /projects`

3. **Get Project by ID**: 
- URL: `GET /projects/{id}`
- Example: `GET /projects/1`

4. **Update Project**: 
- URL: `PUT /projects/{id}`
- Request Body: JSON object representing the updated project
- Example:
  ```json
  {
      "name": "Updated Project Name",
      "description": "Updated Project Description",
      "startDate": "2024-03-15",
      "endDate": "2025-06-30"
  }
  ```

5. **Delete Project**: 
- URL: `DELETE /projects/{id}`
- Example: `DELETE /projects/1`

## Exception Handling
Global exception handling is implemented using `@ControllerAdvice` to manage exceptions and provide meaningful error messages.

## Data Validation
Spring Validation is used to validate input data for create and update operations. Validation constraints are defined in the model classes.

## Testing
Unit tests for service layer methods and integration tests for API endpoints are implemented to ensure the reliability of the application.

## Documentation
API endpoints are documented using Swagger or a similar tool. Access the documentation at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).




