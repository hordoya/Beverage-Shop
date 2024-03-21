Beverage Delivery System with Spring Boot and Google Cloud Platform
Overview
This project is an implementation of a beverage delivery system using Spring Boot for the backend and Google Cloud Platform (GCP) for deployment and cloud services. It allows users to browse beverages, add them to a shopping basket, place orders, and manage user accounts. The system also includes functionality for generating invoices, sending emails, and storing usage statistics.

Features
Display beverages and crates for sale
Add items to a shopping basket and place orders
User registration and address management

Technologies Used
Spring Boot
Thymeleaf (HTML templating engine)
H2 database (for development)
PostgreSQL (Google Cloud SQL for production)
Google Cloud Platform (App Engine)
Setup Instructions
Clone the repository: git clone https://github.com/hordoya/Beverage-Shop.git
Install dependencies: ./gradlew build
Configure application properties for database connections, GCP credentials, etc.
Run the application locally: ./gradlew bootRun
Access the application at http://localhost:8080
