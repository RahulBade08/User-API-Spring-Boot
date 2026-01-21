# User-API-Spring-Boot
User API using Spring Boot

# User Management System – Spring Boot REST API

A simple **User Management REST API** built using **Spring Boot**, demonstrating clean architecture, validation, exception handling, and CRUD operations.

This project is designed for **learning, interviews, and mini-projects**, following industry best practices.

---

## 🚀 Features

- Create a user
- Get all users
- Get user by ID
- Input validation using `@Valid`
- Global exception handling
- Custom error responses
- In-memory H2 database
- Clean layered architecture

---

## 🏗️ Architecture

The project follows **Layered Architecture**:

Controller → Service → Repository → Database
↓
Exception Handling

---

### Layers:
- **Controller** – Handles HTTP requests & responses
- **Service** – Business logic
- **Repository** – Database access using Spring Data JPA
- **Entity** – Database table mapping
- **DTOs** – Request & response models
- **Exception Handling** – Centralized error handling

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database
- Bean Validation (Jakarta Validation)
- Maven

---

## 📂 Project Structure

com.usermanagementsystem
├── controller
├── service
│ └── impl
├── repository
├── entity
├── dto
├── exception
└── UserManagementSystemApplication.java


---

## ⚙️ Configuration

### `application.properties`

```properties
spring.datasource.url=jdbc:h2:mem:userdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

---

🔑 API Endpoints

➕ Create User
POST /api/users
Request Body

{
  "name": "Rahul",
  "email": "rahul@gmail.com"
}
Response

201 Created

📄 Get All Users
GET /api/users
Response

[
  {
    "id": 1,
    "name": "Rahul",
    "email": "rahul@gmail.com"
  }
]

🔍 Get User by ID
GET /api/users/{id}
Success Response

{
  "id": 1,
  "name": "Rahul",
  "email": "rahul@gmail.com"
}
Error Response (404)

{
  "status": 404,
  "message": "User not found",
  "path": "/api/users/99",
  "timestamp": "2026-01-20T00:57:14"
}

❌ Validation & Error Handling
Validation Errors (400)
Handled using MethodArgumentNotValidException.

Example Response

{
  "status": 400,
  "message": "Validation failed",
  "errors": {
    "name": "must not be blank",
    "email": "must be a well-formed email address"
  }
}

Custom Exceptions
UserNotFoundException

Handled globally using @RestControllerAdvice

🧪 H2 Database Console
Access H2 Console at:

http://localhost:8080/h2-console
JDBC URL

jdbc:h2:mem:userdb

---

🧠 Key Learnings

Proper REST API design

DTO usage instead of exposing entities

Exception handling using @RestControllerAdvice

Input validation with meaningful error messages

Clean separation of concerns

--- 

📌 Notes
H2 database is in-memory

Data resets when application restarts

Suitable for learning & demo purposes

👤 Author
Rahul Bade
Email : rahulbade17@gmail.com

⭐ Future Enhancements
Update user API

Pagination & sorting

Swagger / OpenAPI documentation

Database migration to MySQL

Spring Security integration



