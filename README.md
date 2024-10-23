# BankAccountWebService
This Repository demonstrates the basic architecture and implementation of a small web service using NetBankingRESTServer in SpringBoot as backend and NetBankingRESTClient in SpringBoot is acting as client where in service layer it is using RESTTemplate to call NetBankingRESTServer. This service provides an example of how to create Scalable, maintainable, and modular web services for modern web application.

ARCHITECTURE OVERVIEW
1)POJOS (Entities):
Defines the core business data structures (e.g Customer,BankAccount)
Uses JPA to map objects to relational database tables.
2)Repository Layer:
Provides a data access layer using Spring Data JPA to interact with the database.
Contains interfaces extending JpaRepository to handle CRUD operations without needing manual SQL queries also has some finder methods and custom query methods.
3)Service Layer:
Contains business logic.
Acts as a bridge between the controller and repository, ensuring data is processed and validated before interacting with the database.
4)Controller Layer:
Exposes RESTful APIs to interact with the service.
Handles HTTP requests and responses.
5)Exception Handling:
Global exception handling using @ControllerAdvice for consistent error messages and responses.
6)DTOS: 
To hide essential details from entities and send relevant details to frontend.

TECHNOLOGIES USED
Spring Boot: Core framework for building the web service.
Spring Data JPA: For ORM and database interaction.
Hibernate: ORM provider for JPA.
MYSQL Database: for local development
Maven: Dependency management and build tool.
