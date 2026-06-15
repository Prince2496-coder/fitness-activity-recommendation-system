# Fitness Activity Recommendation System

## Overview

Fitness Activity Recommendation System is a Spring Boot backend application that helps users track fitness activities and receive personalized recommendations. The project demonstrates secure REST API development using JWT Authentication, Spring Security, JPA/Hibernate, and MySQL.

## Features

* User Registration
* User Authentication using JWT
* Role-Based Authorization
* Activity Tracking
* Personalized Recommendations
* Secure REST APIs
* Swagger/OpenAPI Documentation
* MySQL Database Integration

## Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Swagger / OpenAPI

## API Modules

### Authentication

* Register User
* Login User
* Generate JWT Token

### Activity Management

* Create Activity
* View Activities
* Manage Activity Records

### Recommendation Management

* Generate Recommendations
* Get Recommendations by User
* Get Recommendations by Activity

## Security Features

* JWT Token-Based Authentication
* Protected Endpoints
* Role-Based Access Control
* Password Encryption using BCrypt

## API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

## Project Structure

```text
controller
service
repository
entity
dto
security
config
```

## How to Run

1. Clone the repository
2. Configure MySQL database
3. Create application.properties
4. Run:

```bash
mvn spring-boot:run
```

## Future Improvements

* Docker Containerization
* Cloud Deployment (AWS/Azure)
* CI/CD Pipeline
* Unit & Integration Testing

## Author

Prince

Java Backend Developer | Spring Boot | Application Security Enthusiast
