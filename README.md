# 🎓 MyStudentManagement

A high-performance **Full-Stack Student Management System** built using **Spring Boot** and **Spring Data JPA**. This project provides a clean REST API and a responsive frontend for seamless student record administration.



---

## 🛠️ Technology Stack
* **Backend:** Java 17, Spring Boot 3.x
* **Persistence:** Spring Data JPA (Hibernate)
* **Database:** SQL (MySQL/PostgreSQL)
* **Frontend:** HTML5, CSS3, JavaScript (Fetch API)
* **Developer Tools:** Lombok, Maven

---

## 📡 REST API Endpoints

| Method | Endpoint | Functionality |
| :--- | :--- | :--- |
| **GET** | `/get` | Retrieve all student records |
| **GET** | `/getid/{id}` | Find a specific student by ID |
| **POST** | `/addstudent` | Create and save a new student |
| **PUT** | `/update/{id}` | Update existing student info |
| **DELETE** | `/delete/{id}` | Remove a student from the database |

---

## 📦 Entity Structure
The `StudentEntity` uses **Lombok** for clean, boilerplate-free code:
* `id`: Primary Key (Auto-Increment)
* `name`: First Name
* `lname`: Last Name
* `age`: Student Age

---
**Author:** 
Krushna Mahajan
