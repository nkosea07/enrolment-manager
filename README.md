# Enrolment Manager

**Student and Teacher Enrolment Service**

---

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
4. [Configuration](#configuration)
5. [Running the Service](#running-the-service)
6. [API Endpoints](#api-endpoints)
7. [Testing the Service](#testing-the-service)
8. [Contributing](#contributing)
9. [License](#license)

---

## Introduction

The Enrolment Manager service is designed to manage student and teacher enrolments. This service allows users to create, read, update, and delete enrolments efficiently.

---

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Maven 3.6.3 or higher
- PostgreSQL 12 or higher
- An IDE (e.g., IntelliJ IDEA, Eclipse)

---

## Setup Instructions

### 1. Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/nkosea07/enrolment-manager.git
cd enrolment-manager

```

### 2. Create the Database

Create a PostgreSQL database named enrolment_manager. You can use pgAdmin or the command line:

```sql
 CREATE DATABASE enrolment_manager;
```

### 3. Set Up PostgreSQL Credentials

Ensure you have your PostgreSQL username and password ready.


### 4. Configure Application Properties

Open the _application-development.properties_ file and set the database connection details:

```properties

spring.datasource.url=jdbc:postgresql://localhost:5432/enrolment_manager
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```

# Running the Service

### Using Maven

Navigate to the project directory and run the application using Maven:

```bash 
 mvn spring-boot:run
```

### Using IDE

 - Import the project into your IDE.
 - Run the EnrolmentManagerApplication class as a Java application.

## API Endpoints

Here’s a list of available endpoints:

## Students
- GET /api/students - Retrieve all students


- GET /api/students/{id} - Retrieve a student by ID


- POST /api/students - Create a new student


- PUT /api/students/{id} - Update a student by ID


- DELETE /api/students/{id} - Delete a student by ID


## Teachers
- GET /api/teachers - Retrieve all teachers


- GET /api/teachers/{id} - Retrieve a teacher by ID


- POST /api/teachers - Create a new teacher


- PUT /api/teachers/{id} - Update a teacher by ID


- DELETE /api/teachers/{id} - Delete a teacher by ID


# Testing the Service

The project has swagger for testing and documentation , to access the swagger ui paste the url below to your browser

```thymeleafurlexpressions
http://yourhost:yourport/swagger-ui/index.html
```