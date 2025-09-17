# Library Management System

A comprehensive Library Management System built with Spring Boot that provides RESTful APIs for managing books, authors, members, and borrowing transactions.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Security](#security)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)

## Overview

This Library Management System is a backend application that provides comprehensive APIs for managing all aspects of a library. It includes functionality for managing books, authors, publishers, categories, library members, and borrowing transactions.

## Features

- **Book Management**: CRUD operations for books with details like ISBN, title, language, publication year, etc.
- **Author Management**: Manage authors with their details
- **Publisher Management**: Manage publishers
- **Category Management**: Categorize books
- **Member Management**: Manage library members
- **Borrowing Transactions**: Track book borrowing and returning
- **User Management**: Role-based user authentication and authorization
- **RESTful APIs**: Clean and consistent API endpoints
- **Data Validation**: Proper validation of input data

## Technologies Used

- **Java 21**: Primary programming language
- **Spring Boot 3.5.5**: Framework for building the application
- **Spring Data JPA**: For database operations
- **Spring Security**: For authentication and authorization
- **MySQL**: Database for persistence
- **Lombok**: For reducing boilerplate code
- **Maven**: Build tool

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.code81.library
│   │       ├── LibraryApplication.java     # Main application class
│   │       ├── config/                     # Configuration classes
│   │       ├── controller/                 # REST controllers
│   │       ├── dto/                        # Data Transfer Objects
│   │       ├── entity/                     # JPA entities
│   │       ├── Enum/                       # Enumerations
│   │       ├── mapper/                     # Entity-DTO mapping
│   │       ├── repository/                 # JPA repositories
│   │       ├── security/                   # Security configuration
│   │       └── service/                    # Business logic
│   │           └── impl/                   # Service implementations
│   └── resources
│       └── application.properties          # Configuration file
└── test                                    # Test classes
```

## API Documentation

The application uses Swagger UI for API documentation and testing.

- **Swagger UI**: http://localhost:8081/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8081/v3/api-docs

You can use the Swagger UI to:
- View all available API endpoints
- See detailed information about each endpoint including parameters and response models
- Test the APIs directly from the browser
- See example requests and responses

Swagger annotations have been added to the controllers to provide detailed documentation for each endpoint.

## API Endpoints

### Books
- `GET /api/books` - Get all books
- `GET /api/books/{isbn}` - Get a book by ISBN
- `POST /api/books` - Create a new book
- `PUT /api/books/{isbn}` - Update a book
- `DELETE /api/books/{isbn}` - Delete a book

### Authors
- `GET /api/authors` - Get all authors
- `GET /api/authors/{id}` - Get an author by ID
- `POST /api/authors` - Create a new author
- `PUT /api/authors/{id}` - Update an author
- `DELETE /api/authors/{id}` - Delete an author

### Publishers
- `GET /api/publishers` - Get all publishers
- `GET /api/publishers/{id}` - Get a publisher by ID
- `POST /api/publishers` - Create a new publisher
- `PUT /api/publishers/{id}` - Update a publisher
- `DELETE /api/publishers/{id}` - Delete a publisher

### Categories
- `GET /api/categories` - Get all categories
- `GET /api/categories/{id}` - Get a category by ID
- `POST /api/categories` - Create a new category
- `PUT /api/categories/{id}` - Update a category
- `DELETE /api/categories/{id}` - Delete a category

### Members
- `GET /api/members` - Get all members
- `GET /api/members/{id}` - Get a member by ID
- `POST /api/members` - Create a new member
- `PUT /api/members/{id}` - Update a member
- `DELETE /api/members/{id}` - Delete a member

### Borrowing Transactions
- `GET /api/transactions` - Get all transactions
- `GET /api/transactions/{id}` - Get a transaction by ID
- `POST /api/transactions` - Create a new transaction
- `PUT /api/transactions/{id}` - Update a transaction
- `DELETE /api/transactions/{id}` - Delete a transaction

### Users
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get a user by ID
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update a user
- `DELETE /api/users/{id}` - Delete a user

## Database Schema

The application uses the following main entities:

- **Book**: Represents a book with ISBN, title, language, publication year, etc.
- **Author**: Represents an author with name and other details
- **Publisher**: Represents a publisher
- **Category**: Represents book categories
- **Member**: Represents a library member
- **BorrowingTransaction**: Represents borrowing/returning transactions
- **User**: Represents system users with roles

Relationships:
- Books can have multiple authors (Many-to-Many)
- Books belong to one publisher (Many-to-One)
- Books can have multiple categories (Many-to-Many)
- Books can be part of multiple borrowing transactions (One-to-Many)
- Members can have multiple borrowing transactions (One-to-Many)

## Security

The application implements role-based access control with the following roles:
- **ADMIN**: Full access to all endpoints
- **LIBRARIAN**: Access to books, members, and transactions management
- **STAFF**: Read access to books and transactions

Authentication is implemented using HTTP Basic Authentication.

## Setup and Installation

1. **Prerequisites**:
   - Java 21
   - MySQL database
   - Maven

2. **Database Setup**:
   - Create a MySQL database named `librarydb`
   - Update the database credentials in `src/main/resources/application.properties` if needed

3. **Configuration**:
   - Update database credentials in `application.properties` if different from defaults

## Running the Application

1. **Build the project**:
   ```bash
   mvn clean install
   ```

2. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   Or:
   ```bash
   java -jar target/library-0.0.1-SNAPSHOT.jar
   ```

3. **Access the application**:
   The application will start on `http://localhost:8081`

## API Documentation

The application uses Swagger UI for API documentation and testing.

- **Swagger UI**: http://localhost:8081/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8081/v3/api-docs

You can use the Swagger UI to:
- View all available API endpoints
- See detailed information about each endpoint including parameters and response models
- Test the APIs directly from the browser
- See example requests and responses

## Development

The application is configured to run on port 8081. You can change this in the `application.properties` file.