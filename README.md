Mini E-commerce Backend (Spring Boot)

A simple REST API backend for a mini e-commerce app. Handles users, products, orders, and admin tasks. Built with Spring
Boot and MySQL.

Features

User Auth: JWT-based login & registration

Product Management: CRUD + stock tracking

Order Processing: Create orders & automatically update stock

Admin Panel: Manage products, view all orders, low stock alerts

Database: MySQL with JPA/Hibernate

Tech Stack

Java 17, Spring Boot 3.5.5

Spring Security + JWT

Spring Data JPA

MySQL

Maven & Lombok

Database Entities

User: Users with roles (USER / ADMIN)

Product: Catalog info + stock

Order: Orders with status

OrderItem: Items inside orders

API Endpoints

Authentication

POST /auth/register → signup

POST /auth/login → get JWT

Products

GET /products → list all

GET /products/{id} → single product

POST /products → create (admin only)

Orders

POST /orders → create order

GET /orders/me → current user orders

Admin

GET /admin/orders → all orders

GET /admin/low-stock → products with stock < 5

Getting Started

Install Java 17+, MySQL, Maven

Create database: mini-ecommerce

Update application.properties with your DB credentials

Run:

./mvnw spring-boot:run

Server runs on http://localhost:8081

Sample Admin User: admin@example.com / admin123

Example Requests

Register

curl -X POST http://localhost:8081/auth/register \
-H "Content-Type: application/json" \
-d '{"email":"user@example.com","password":"password123"}'

Login

curl -X POST http://localhost:8081/auth/login \
-H "Content-Type: application/json" \
-d '{"email":"user@example.com","password":"password123"}'

Get Products

curl http://localhost:8081/products

Create Order (JWT required)

curl -X POST http://localhost:8081/orders \
-H "Content-Type: application/json" \
-H "Authorization: Bearer YOUR_JWT_TOKEN" \
-d '{"items":[{"productId":1,"quantity":2}]}'

Admin: Create Product

curl -X POST http://localhost:8081/products \
-H "Content-Type: application/json" \
-H "Authorization: Bearer ADMIN_JWT_TOKEN" \
-d '{"name":"New Product","price":99.99,"stock":10}'

Project Structure
src/main/java/com/salahhaddara/springbootminiecommerce/
├── config/ # Configurations
├── controller/ # REST controllers
├── dto/ # Request & response objects
├── entity/ # Database entities
├── repository/ # Data access
├── security/ # Security config & JWT
├── service/ # Business logic
└── util/ # Utilities / helpers