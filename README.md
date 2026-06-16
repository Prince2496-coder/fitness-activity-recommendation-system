# Fitness Activity Recommendation System

## Overview

Fitness Activity Recommendation System is a secure Spring Boot REST API that enables users to track fitness activities and receive personalized activity recommendations. The application demonstrates modern backend development practices including JWT Authentication, Spring Security, Role-Based Authorization, JPA/Hibernate, Docker containerization, and cloud deployment.

The project is containerized using Docker and deployed on Render.

---

## Features

### User Management

* User Registration
* User Authentication
* JWT Token Generation
* Secure Login System

### Activity Management

* Create Activities
* Track Fitness Progress
* View Activity History
* Manage Activity Records

### Recommendation System

* Generate Personalized Recommendations
* Retrieve Recommendations by User
* Retrieve Recommendations by Activity

### Security

* JWT Authentication
* Role-Based Authorization
* BCrypt Password Encryption
* Protected REST Endpoints

### Documentation

* Swagger/OpenAPI Integration
* Interactive API Testing Interface

---

## Tech Stack

### Backend

* Java 24
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Authentication

* JWT (JSON Web Token)

### Database

* MySQL

### DevOps & Deployment

* Docker
* Docker Hub
* Render

### Tools

* Maven
* Swagger / OpenAPI

---

## Project Architecture

```text
src
├── controller
├── service
├── repository
├── model
├── dto
├── security
├── config
└── resources
```

---

## API Modules

### Authentication APIs

| Method | Endpoint       | Description   |
| ------ | -------------- | ------------- |
| POST   | /auth/register | Register User |
| POST   | /auth/login    | Login User    |

### Activity APIs

| Method | Description     |
| ------ | --------------- |
| POST   | Create Activity |
| GET    | View Activities |
| PUT    | Update Activity |
| DELETE | Delete Activity |

### Recommendation APIs

| Method | Description                |
| ------ | -------------------------- |
| POST   | Generate Recommendation    |
| GET    | Get Recommendation         |
| GET    | Get Recommendation by User |

---

## Security Features

* JWT Token-Based Authentication
* Role-Based Access Control
* BCrypt Password Encryption
* Stateless Authentication
* Protected REST APIs

---

## API Documentation

### Local Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

### Live Swagger UI

```text
https://fitness-rqy1.onrender.com/swagger-ui/index.html
```

---

## Local Setup

### Clone Repository

```bash
git clone https://github.com/Prince2496-coder/fitness-activity-recommendation-system.git
```

### Move into Project

```bash
cd fitness-activity-recommendation-system
```

### Configure Environment Variables

```properties
DB_URL=your_database_url
DB_NAME=your_database_username
DB_PAS=your_database_password
DB_SECRET=your_jwt_secret
```

### Run Application

```bash
mvn spring-boot:run
```

---

## Docker Deployment

### Build Docker Image

```bash
docker build -t fitness-app .
```

### Run Docker Container

```bash
docker run -d -p 8080:8080 \
-e DB_URL=<database_url> \
-e DB_NAME=<database_username> \
-e DB_PAS=<database_password> \
-e DB_SECRET=<jwt_secret> \
fitness-app
```

---

## Docker Hub

Docker Image:

```text
prrinceohlyan09/fit_x:latest
```

Pull Image:

```bash
docker pull prrinceohlyan09/fit_x:latest
```

---

## Cloud Deployment

The application is deployed on Render using Docker.

Live URL:

```text
https://fitness-rqy1.onrender.com
```

---

## Future Enhancements

* GitHub Actions CI/CD Pipeline
* Unit Testing
* Integration Testing
* Activity Analytics Dashboard
* Email Notifications
* Mobile Application Integration
* AI-Based Recommendation Engine

---

## Author

Prince Kumar

Backend Developer | Java | Spring Boot | Docker
