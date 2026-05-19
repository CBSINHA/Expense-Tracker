# Secure Multi-User Expense Tracker API

A production-style backend expense tracking application built using Spring Boot, Spring Security, JWT Authentication, and PostgreSQL.

This project demonstrates secure REST API development with authentication, authorization, pagination, filtering, searching, sorting, and multi-user resource isolation.

> **Note:**
> The backend is deployed on Render's free tier.
> If the API has been inactive for some time, the first request may take around 30–60 seconds while the server wakes up.

---

# Live API

## Backend Base URL

https://expense-tracker-ojay.onrender.com

## Swagger Documentation

https://expense-tracker-ojay.onrender.com/swagger-ui/index.html

## Frontend Application

https://expense-tracker-frontend-brown-xi.vercel.app/

---

# Features

## Authentication & Security

* User Registration
* Optional Email Registration
* User Login
* JWT Authentication
* BCrypt Password Hashing
* Stateless Authentication
* Protected Routes using Spring Security
* Secure Multi-User Data Isolation
* Authorization-based Resource Ownership Validation

## Expense Management

* Create Expense
* Read Expenses
* Update Expense
* Delete Expense
* Search Expenses
* Filter Expenses by Category
* Sort Expenses
* Pagination Support
* Show All Expenses
* Custom Expense Categories

## Backend Engineering

* Layered Architecture
* DTO Pattern
* Global Exception Handling
* Jakarta Validation
* RESTful API Design
* Swagger/OpenAPI Documentation
* PostgreSQL Cloud Database
* Secure User-Specific Query Handling

---

# Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (JJWT)
* Hibernate / JPA
* PostgreSQL
* Maven
* Swagger / OpenAPI
* Neon Database

---

# Architecture

```text
Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
PostgreSQL Database
```

---

# Authentication Flow

```text
User Login
     ↓
JWT Token Generated
     ↓
Client Sends JWT Token
     ↓
JWT Filter Validates Token
     ↓
Spring Security Authenticates Request
```

---

# API Endpoints

## Authentication APIs

| Method | Endpoint         | Description   |
| ------ | ---------------- | ------------- |
| POST   | `/auth/register` | Register User |
| POST   | `/auth/login`    | Login User    |

---

## Expense APIs

| Method | Endpoint                          | Description           |
| ------ | --------------------------------- | --------------------- |
| GET    | `/expenses`                       | Get All User Expenses |
| GET    | `/expenses/{id}`                  | Get Expense By ID     |
| POST   | `/expenses`                       | Add Expense           |
| PUT    | `/expenses/{id}`                  | Update Expense        |
| DELETE | `/expenses/{id}`                  | Delete Expense        |
| GET    | `/expenses/search?keyword=`       | Search Expenses       |
| GET    | `/expenses/category/{category}`   | Filter By Category    |
| GET    | `/expenses/sorted/{field}`        | Sort Expenses         |
| GET    | `/expenses/paginated?page=&size=` | Paginated Expenses    |

---

# API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

Production Swagger URL:

```text
https://expense-tracker-ojay.onrender.com/swagger-ui/index.html
```

---

# Setup Instructions

## Clone Repository

```bash
git clone https://github.com/CBSINHA/Expense-Tracker
```

---

# Configure Environment Variables

Create `application.properties` (`example-application.properties` already provided under `src/main/resources/`):

```properties
spring.application.name=expense-tracker

spring.datasource.url=YOUR_DB_URL
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=YOUR_SECRET_KEY
jwt.expiration=36000000
```

---

# Run Application

```bash
mvn spring-boot:run
```

---

# Example Authorization Header

```http
Authorization: Bearer YOUR_JWT_TOKEN
```

---

# Security Improvements Implemented

* User-specific expense isolation
* Secure filtering/searching/sorting
* Ownership validation for update/delete operations
* Stateless JWT-based authentication
* Protected REST endpoints using Spring Security

---

# Key Learnings

* Implemented JWT authentication using Spring Security.
* Built secure multi-user REST APIs with resource ownership validation.
* Designed layered backend architecture using DTOs and service-repository pattern.
* Implemented searching, filtering, sorting, pagination, and CRUD operations.
* Integrated PostgreSQL cloud database using Neon.
* Implemented validation and global exception handling for robust APIs.
* Deployed production-style backend using Render.

---

# Future Improvements

* Docker Deployment
* Expense Analytics Dashboard
* Budget Management
* Export Features
* Unit & Integration Testing

---

# Author

Shashank Sinha
