📌 TaskFlow Platform

A full-stack Project Management System inspired by tools like Jira, designed to improve team collaboration, task tracking, and workflow management.

Built using Spring Boot, React, and MySQL, this project demonstrates real-world backend architecture, REST API design, and role-based access control.

🚀 Overview

TaskFlow Platform helps teams manage projects efficiently by organizing work into tasks, assigning responsibilities, and tracking progress through a structured workflow system.

It simulates real-world software development environments with role-based permissions and structured task lifecycles.

✨ Key Features
👤 Authentication & Authorization
User registration and login
JWT-based authentication
Role-based access control (Admin, Manager, Developer)
🧑‍💼 Team Management
Create and manage teams
Add or remove team members
Assign roles to users
📁 Project Management
Create and manage projects
Assign teams to projects
Track project progress
✅ Task Management
Create, update, delete tasks
Assign tasks to users
Task status workflow (TODO → IN_PROGRESS → REVIEW → DONE)
Priority levels (LOW, MEDIUM, HIGH, CRITICAL)
💬 Collaboration
Task comments system
Activity logging for tracking changes
📊 Analytics (Planned / Optional)
Task completion statistics
Project progress tracking dashboard
🏗️ System Architecture
Frontend (React)
        ↓
REST API (Spring Boot)
        ↓
Service Layer (Business Logic)
        ↓
Repository Layer (JPA/Hibernate)
        ↓
MySQL Database
🧠 Tech Stack
Backend
Java
Spring Boot
Spring Security
Spring Data JPA
Hibernate
MySQL
JWT Authentication
Frontend
React.js
Axios
Tailwind CSS / CSS Modules (optional)
Tools
Maven
Git & GitHub
Postman
IntelliJ IDEA
📂 Project Structure
Backend
backend/
 ├── controller
 ├── service
 │    └── impl
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── config
 ├── exception
 ├── enums
 └── TaskflowApplication.java
🔄 Task Workflow

Tasks follow a strict lifecycle:

TODO → IN_PROGRESS → REVIEW → DONE
Business Rules:
Tasks cannot skip stages
Only assigned users can update task status
Managers control task assignment
🔐 Security Model
JWT token-based authentication
Password encryption using BCrypt
Role-based route protection
Stateless session handling
📊 Role Permissions
Role	Permissions
Admin	Full system access
Manager	Manage projects & tasks
Developer	View & update assigned tasks
📌 API Design (Example)
Authentication
POST /api/auth/register
POST /api/auth/login
Projects
GET    /api/projects
POST   /api/projects
PUT    /api/projects/{id}
DELETE /api/projects/{id}
Tasks
GET    /api/tasks
POST   /api/tasks
PUT    /api/tasks/{id}
PATCH  /api/tasks/{id}/status
📈 Learning Outcomes

This project demonstrates:

REST API development
Layered architecture (Controller → Service → Repository)
Database design and relationships
Authentication & authorization
OOP principles (Encapsulation, Abstraction, Polymorphism)
SOLID principles in backend design
Real-world workflow modeling
🎯 Future Improvements
Real-time notifications (WebSocket)
File attachments for tasks
Advanced analytics dashboard
Email notifications
Docker deployment
CI/CD pipeline
👨‍💻 Author

Kalindu Methmuditha
IT Undergraduate
Aspiring Fullstack Developer (Spring Boot | MERN)

📌 Note
