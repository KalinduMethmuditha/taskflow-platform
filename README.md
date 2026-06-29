# 🚀 TaskFlow - Project Management System

TaskFlow is a full-stack project management system built with **Spring Boot**, **MySQL**, and **React** (frontend coming soon). It helps teams manage projects, assign tasks, and track progress securely using JWT authentication and role-based access control.

---

## 📌 Features

### Authentication & Security
- JWT Authentication
- BCrypt Password Encryption
- Role-Based Authorization (ADMIN, MANAGER, DEVELOPER)
- Spring Security

### User Management
- Create users
- Update users
- Delete users
- View user details

### Project Management
- Create projects
- Update projects
- Delete projects
- Assign project owner
- Track project status

### Task Management
- Create tasks
- Assign tasks to developers
- Update task status
- View project tasks

### Backend Features
- RESTful API
- DTO Pattern
- Mapper Pattern
- Global Exception Handling
- Input Validation
- Spring Data JPA
- MySQL Database

---

## 🛠 Tech Stack

### Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL
- JWT
- Maven
- Lombok

### Frontend

- React (Coming Soon)
- Axios
- React Router

---

## 📂 Project Structure

```text
src/main/java/com/kalindu/taskflow

├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── mapper
├── repository
├── security
├── service
│   └── impl
└── TaskFlowApplication
```

---

## 🗄 Database Design

### User

| Field | Type |
|-------|------|
| id | Long |
| fullName | String |
| email | String |
| password | String |
| role | ADMIN / MANAGER / DEVELOPER |

---

### Project

| Field | Type |
|-------|------|
| id | Long |
| name | String |
| description | String |
| status | PLANNING / IN_PROGRESS / COMPLETED |
| owner | User |

---

### Task

| Field | Type |
|-------|------|
| id | Long |
| description | String |
| status | TODO / IN_PROGRESS / DONE |
| project | Project |
| assignedUser | User |

---

## 🔐 Authentication

Login

```
POST /api/auth/login
```

Example Request

```json
{
    "email":"admin@taskflow.com",
    "password":"123456"
}
```

Response

```json
{
    "token":"JWT_TOKEN"
}
```

Use the token in every protected request.

```
Authorization: Bearer YOUR_JWT_TOKEN
```

---

## 📡 API Endpoints

### Authentication

| Method | Endpoint |
|---------|----------|
| POST | /api/auth/login |

---

### Users

| Method | Endpoint |
|---------|----------|
| GET | /api/users |
| GET | /api/users/{id} |
| POST | /api/users |
| PUT | /api/users/{id} |
| DELETE | /api/users/{id} |

---

### Projects

| Method | Endpoint |
|---------|----------|
| GET | /api/projects |
| GET | /api/projects/{id} |
| POST | /api/projects |
| PUT | /api/projects/{id} |
| DELETE | /api/projects/{id} |

---

### Tasks

| Method | Endpoint |
|---------|----------|
| GET | /api/tasks |
| GET | /api/tasks/{id} |
| POST | /api/tasks |
| PATCH | /api/tasks/{id}/status |
| DELETE | /api/tasks/{id} |

---

## 🔑 User Roles

| Role | Permissions |
|------|-------------|
| ADMIN | Full system access |
| MANAGER | Manage projects and tasks |
| DEVELOPER | Update assigned task status |

---

## ▶️ Running the Project

Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/taskflow.git
```

Navigate to the project

```bash
cd taskflow
```

Configure MySQL in

```
application.properties
```

Run

```bash
mvn spring-boot:run
```

---

## 📷 Screenshots

(Add these after completing the project)

- Swagger UI
- MySQL Database
- Postman
- React Dashboard

---

## 📈 Future Improvements

- React Frontend
- Docker
- Deployment
- Unit Testing
- CI/CD
- Email Notifications
- File Attachments
- Comments
- Activity Logs

---

## 👨‍💻 Author

**Kalindu Methmuditha**

Software Engineering Undergraduate

GitHub: https://github.com/YOUR_USERNAME

LinkedIn: https://linkedin.com/in/YOUR_LINKEDIN
