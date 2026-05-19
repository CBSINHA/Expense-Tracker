# Secure Full-Stack Expense Tracker

A production-style full-stack expense tracking application built using Spring Boot, Spring Security, JWT Authentication, PostgreSQL, React, and Tailwind CSS.

This project demonstrates secure REST API development with authentication, authorization, pagination, filtering, searching, and multi-user data isolation, along with a clean frontend interface integrated with protected backend APIs.

> **Note:**
> The backend is deployed on Render's free tier.
> If the application has been inactive for some time, the first request may take around 30–60 seconds while the backend server wakes up.

---

# Live Demo

## Frontend Application

https://expense-tracker-frontend-brown-xi.vercel.app/

## Backend API

https://expense-tracker-ojay.onrender.com

## Swagger Documentation

https://expense-tracker-ojay.onrender.com/swagger-ui/index.html

---

# Features

## Authentication & Security

* User Registration
* User Login
* JWT Authentication
* BCrypt Password Hashing
* Protected Routes using Spring Security
* Stateless Authentication
* Multi-User Data Isolation

## Expense Management

* Create Expense
* Update Expense
* Delete Expense
* Get All User Expenses
* Search Expenses
* Filter Expenses by Category
* Sort Expenses
* Pagination Support

## Frontend Features

* Secure Login & Registration UI
* Protected Dashboard Route
* JWT Token Storage
* Expense Creation & Deletion
* Total Expense Calculation
* Toast Notifications
* Responsive Dark-Themed UI

## Backend Engineering

* Layered Architecture
* DTO Pattern
* Global Exception Handling
* Validation using Jakarta Validation
* RESTful API Design
* PostgreSQL Cloud Database (Neon)
* Swagger/OpenAPI Documentation

---

# Tech Stack

## Backend

* Java
* Spring Boot
* Spring Security
* JWT (JJWT)
* Hibernate / JPA
* PostgreSQL
* Maven
* Swagger / OpenAPI
* Neon Database

## Frontend

* React
* Vite
* Tailwind CSS
* Axios
* React Router
* React Hot Toast

## Deployment

* Render (Backend)
* Vercel (Frontend)

---

# Architecture

```text id="1w5umr"
React Frontend
       ↓
REST APIs
       ↓
Spring Boot Backend
       ↓
PostgreSQL Database
```

## Authentication Flow

```text id="buzmho"
User Login
     ↓
JWT Token Generated
     ↓
Frontend Stores Token
     ↓
Token Sent in Authorization Header
     ↓
JWT Filter Validates Token
     ↓
Spring Security Authenticates Request
```

---

# API Documentation

Swagger UI:

```text id="nrxb5u"
http://localhost:8080/swagger-ui/index.html
```

Production Swagger URL:

```text id="6lcr0q"
https://expense-tracker-ojay.onrender.com/swagger-ui/index.html
```

---

# Setup Instructions

## Clone Backend Repository

```bash id="3zw5u6"
git clone https://github.com/CBSINHA/Expense-Tracker
```

## Clone Frontend Repository

```bash id="olpbhw"
git clone https://github.com/CBSINHA/expense-tracker-frontend
```

---

# Backend Configuration

Create `application.properties` (`example-application.properties` already provided under `src/main/resources/`):

```properties id="e63nvt"
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

# Run Backend

```bash id="jlwmg1"
mvn spring-boot:run
```

---

# Run Frontend

```bash id="jlwmg2"
npm install
npm run dev
```

---

# Example Authorization Header

```http id="jlwmg3"
Authorization: Bearer YOUR_JWT_TOKEN
```

---

# Key Learnings

* Implemented JWT-based stateless authentication using Spring Security.
* Built protected REST APIs with secure user-specific expense access.
* Integrated React frontend with secured backend APIs using Axios interceptors.
* Managed CORS configuration for frontend-backend communication.
* Designed layered backend architecture using DTOs and service-repository pattern.
* Implemented validation and global exception handling for robust API responses.
* Deployed a full-stack application using Render and Vercel.

---

# Future Improvements

* Docker Deployment
* Expense Analytics Dashboard
* Budget Management
* Export Features

---

# Author

Shashank Sinha
