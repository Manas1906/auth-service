# FreshLink Authentication Service

A production-ready authentication microservice built using Spring Boot and MySQL.  
This service provides secure user registration and login using JWT-based stateless authentication and role-based authorization.

---

## Features

- JWT token-based authentication  
- Role-based authorization (ADMIN, CUSTOMER, SELLER, DELIVERY)
- BCrypt password encryption  
- MySQL persistence using JPA/Hibernate  
- Stateless security design  
- RESTful APIs  
- Clean layered architecture  

---

## Tech Stack

- Java 17  
- Spring Boot 3  
- Spring Security  
- JWT (JJWT)  
- MySQL  
- Hibernate / JPA  

---

## API Endpoints

| Method | Endpoint | Description |
|-------|---------|------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Authenticate user |
| GET | /api/user/profile | Get logged in user (JWT required) |

---

## Sample Register Request

```json
{
  "fullName": "Manas Acharya",
  "email": "manas@freshlink.com",
  "password": "123456",
  "role": "ADMIN"
}

