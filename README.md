# School Management API

A RESTful API for managing students and academic programs (filières), built with Spring Boot.

## Features

- CRUD operations for students and filières
- Input validation with Bean Validation
- API documentation via Swagger UI (SpringDoc OpenAPI)
- MySQL persistence with JPA/Hibernate

## Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8+

## Installation
```bash
git clone https://github.com/your-username/shcool-management.git
cd shcool-management
```

Create the database and configure your credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/school_db?createDatabaseIfNotExist=true
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Then run:
```bash
./mvnw spring-boot:run
```

## API Endpoints

| Method | Endpoint          | Description          |
|--------|-------------------|----------------------|
| GET    | /students         | Get all students     |
| GET    | /students/{id}    | Get student by ID    |
| POST   | /students         | Create a student     |
| POST   | /students/{id}    | Update a student     |
| DELETE | /students/{id}    | Delete a student     |

Full interactive docs available at: `http://localhost:8080/swagger-ui.html`

## Project Structure
```
src/main/java/ma/fstgm/security/shcoolmanagement/
├── controller/     # REST controllers
├── dto/
│   ├── request/    # Input DTOs
│   └── response/   # Output DTOs
├── entities/       # JPA entities (Student, Filiere)
├── exceptions/     # Custom exceptions
├── mapper/         # Entity ↔ DTO mappers
├── repositories/   # Spring Data JPA repositories
└── services/       # Business logic
```
## UML 

<img width="651" height="602" alt="Diagramme sans nom drawio" src="https://github.com/user-attachments/assets/a0d4b4c7-c16b-4111-9248-3c90d49377aa" />


## Tech Stack

- Spring Boot 4.0.5
- Spring Data JPA
- MySQL
- Lombok
- SpringDoc OpenAPI 3

## License

MIT
