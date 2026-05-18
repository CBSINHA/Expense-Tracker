# Secure Multi-User Expense Tracker API

A production-style backend expense tracking application built using Spring Boot, PostgreSQL, JWT Authentication, and Spring Security.

This project demonstrates secure REST API development with authentication, authorization, pagination, filtering, searching, and multi-user data isolation.

---

# Features

## Authentication & Security

* User Registration
* User Login
* JWT Authentication
* BCrypt Password Hashing
* Protected Routes using Spring Security
* Stateless Authentication

## Expense Management

* Create Expense
* Update Expense
* Delete Expense
* Get All User Expenses
* Search Expenses
* Filter Expenses by Category
* Sort Expenses
* Pagination Support

## Backend Engineering

* Layered Architecture
* DTO Pattern
* Global Exception Handling
* Validation using Jakarta Validation
* PostgreSQL Cloud Database (Neon)
* Swagger/OpenAPI Documentation

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

Authentication Flow:

```text
    Login
      ↓
JWT Token Generated
      ↓
Client Sends Token
      ↓
JWT Filter Validates Token
      ↓
Spring Security Authenticates Request
```

---

# API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Setup Instructions

## Clone Repository

```bash
git clone https://github.com/CBSINHA/Expense-Tracker
```

## Configure Environment Variables

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


# Live Demo

**API Base URL:**```
 https://expense-tracker-ojay.onrender.com```

**Swagger Documentation:**
```https://expense-tracker-ojay.onrender.com/swagger-ui/index.html```

---

# Future Improvements

* Frontend Upgrade
* Docker Deployment
* Expense Analytics Dashboard
* Budget Management
* Export Features

---

# Author

Shashank Sinha
