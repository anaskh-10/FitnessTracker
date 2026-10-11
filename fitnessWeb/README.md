# FitnessTracker 🏋️

A full-stack fitness tracking web application that helps users manage their workouts, record daily physical activities, set fitness goals, and monitor their progress through an interactive dashboard.

Built with **Angular**, **Spring Boot**, and **MySQL**, the project demonstrates the development of a web application with a responsive frontend, RESTful APIs, and database integration.

## ✨ Features

### 👤 User Authentication
- User registration and login.
- Form validation for required fields.
- Session-based authentication on the backend.
- Protected application pages for authenticated users.

### 🏋️ Workout Management
- Add and record workout sessions.
- Select workout types, including Cardio, Strength, HIIT, Swimming, Cycling, and more.
- Record workout duration, date, and calories burned.
- View and delete recorded workouts.

### 🚶 Physical Activity Tracking
- Record daily physical activities.
- Track steps, distance, calories burned, and activity date.
- View recorded activities.
- Delete activity records.

### 🎯 Fitness Goals
- Create goals with descriptions, start dates, and end dates.
- View existing goals.
- Update goal status.
- Delete goals.

### 📊 Interactive Dashboard
- View fitness statistics.
- Visualize workout and activity data using charts.
- Monitor calories burned, workout duration, steps, and distance over time.

## 🛠️ Technologies Used

**Frontend**
- Angular 18
- TypeScript
- HTML5 and SCSS
- NG-ZORRO Ant Design
- Chart.js
- RxJS

**Backend**
- Java 21
- Spring Boot 3.4.1
- Spring Web (REST APIs)
- Spring Data JPA
- Hibernate
- Maven

**Database**
- MySQL

**Development Tools**
- Visual Studio Code
- IntelliJ IDEA
- Postman
- Git and GitHub

## 🏗️ Project Architecture

The application follows a client-server architecture.

- **Angular frontend:** Provides the user interface and communicates with the backend through HTTP requests.
- **Spring Boot backend:** Exposes REST endpoints and implements application logic through controllers, services, repositories, entities, and DTOs.
- **MySQL database:** Stores application data and is accessed through Spring Data JPA and Hibernate.

## 📁 Project Structure

```text
FitnessTracker/
├── Diagram/                 # UML diagrams
├── Interface/               # Application interface screenshots
├── Logo/                    # Technology logos
├── fitnessTrackerServer/    # Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/        # Application source code
│   │   │   └── resources/   # Configuration files
│   │   └── test/            # Backend tests
│   └── pom.xml
└── fitnessWeb/              # Angular frontend
    ├── public/
    ├── src/
    │   └── app/
    │       ├── components/  # Application pages
    │       ├── guard/       # Route protection
    │       ├── service/     # API and authentication services
    │       └── shared/      # Shared modules
    ├── angular.json
    └── package.json
```

## ⚙️ Installation and Setup

### Prerequisites

Make sure you have installed:

- Java Development Kit (JDK) 21
- Node.js and npm
- Angular CLI 18
- MySQL Server
- Git

### 1. Clone the Repository

```bash
git clone https://github.com/anaskh-10/FitnessTracker.git
cd FitnessTracker
```

### 2. Configure the Database

Create a MySQL database named `Fitness_db`.

```sql
CREATE DATABASE Fitness_db;
```

The backend configuration currently expects MySQL on port `3308`, with username `root` and an empty password.

Check `fitnessTrackerServer/src/main/resources/application.properties` and update the database URL, username, and password to match your local MySQL configuration.

Hibernate is configured to update the database schema automatically.

### 3. Run the Backend

Open a terminal in the backend directory:

```bash
cd fitnessTrackerServer
```

Run the application using the Maven wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The Spring Boot server runs on:

`http://localhost:8089`

### 4. Run the Frontend

Open a second terminal in the frontend directory:

```bash
cd fitnessWeb
```

Install the dependencies:

```bash
npm install
```

Start the Angular development server:

```bash
npm start
```

Open the local URL displayed in the terminal, usually:

`http://localhost:4200`

**Important:** The frontend currently sends API requests to `http://localhost:8089/`. Keep the backend running and configure MySQL correctly for the application to work.

## 🔌 Main API Endpoints

The backend exposes REST endpoints for the application's main features.

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a user |
| POST | `/api/auth/login` | Log in |
| POST | `/api/auth/logout` | Log out |
| POST | `/api/workout` | Create a workout |
| GET | `/api/workouts` | Retrieve workouts |
| DELETE | `/api/workout/{id}` | Delete a workout |
| POST | `/api/activity` | Record an activity |
| GET | `/api/activities` | Retrieve activities |
| DELETE | `/api/activity/{id}` | Delete an activity |
| POST | `/api/goal` | Create a goal |
| GET | `/api/goals` | Retrieve goals |
| GET | `/api/goal/status/{id}` | Update goal status |
| DELETE | `/api/goal/{id}` | Delete a goal |
| GET | `/api/stats` | Retrieve dashboard statistics |
| GET | `/api/graphs` | Retrieve chart data |

## 🎯 Project Objectives

- Develop a full-stack web application using modern frontend and backend technologies.
- Design and implement RESTful APIs.
- Integrate a relational database using Spring Data JPA and Hibernate.
- Implement user registration, login, and protected routes.
- Manage workouts, physical activities, and personal fitness goals.
- Present fitness data through interactive charts and statistics.

## 👨‍💻 Author

**Anas Khiari**

GitHub: [@anaskh-10](https://github.com/anaskh-10)

---

*FitnessTracker is a learning project focused on full-stack web development and fitness data management.*
