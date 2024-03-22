Overview
This project is an implementation of a beverage delivery system using Spring Boot for the backend and Google Cloud Platform (GCP) for deployment and cloud services. It allows users to browse beverages, add them to a shopping basket, place orders, and manage user accounts
Features
•	Display beverages and crates for sale
•	Add items to a shopping basket and place orders
•	User registration and address management
•	User authentication and authorization
Technologies Used
•	Spring Boot
•	Thymeleaf (HTML templating engine)
•	H2 database (for development)
•	PostgreSQL (Google Cloud SQL for production)
•	Google Cloud Platform (App Engine)
Setup Instructions
1.	Clone the repository: git clone https://github.com/hordoya/Beverage-Shop.git
2.	Install dependencies: ./gradlew build
3.	Configure application properties for database connections, GCP credentials, etc.
4.	Run the application locally: ./gradlew bootRun
5.	Access the application at http://localhost:8080


