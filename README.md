# Pet Palace - E-Commerce System (Full-Stack Implementation)

## Group Members
- **Rence A. Escala** (BSIT 2B)
- **Lyza Atencio** (BSIT 2B)

**Course:** WS101 (Information Management)
**University:** University of Eastern Philippines

## Project Overview
**Pet Palace** is a mini e-commerce application developed as a collaborative project for Laboratory 8. This project demonstrates full-stack integration by connecting a **Spring Boot (Backend)**, a **MySQL (Database)**, and a **Vanilla JavaScript (Frontend)**. 

The system has transitioned from hardcoded data to a dynamic architecture, utilizing the Fetch API to retrieve product information in real-time from the database.

## Technologies Used
- **Backend:** Java Spring Boot 3 (Jakarta EE)
- **Database:** MySQL
- **Frontend:** HTML5, CSS3, JavaScript (Fetch API)
- **Tools:** Spring Data JPA, Hibernate, GitHub, Figma (Prototyping)

## Project Structure
- `src/main/java/` - Logic for Controller, Service, Model, and Repository layers.
- `src/main/resources/static/` - Stores all Frontend assets (HTML, CSS, JS, and Images).
- `src/main/resources/application.properties` - Database connection settings.

## How to Run
1. **Setup Database:**
   - Open MySQL and create the database: `CREATE DATABASE pet_palace;`
2. **Configure Connection:**
   - Update `application.properties` with your local MySQL credentials (username/password).
3. **Run the Application:**
   - Execute the Spring Boot application and navigate to `http://localhost:8080/landing.html`.

## Lab 8 Key Features
- [x] **Database Integration:** Product management via MySQL.
- [x] **Dynamic Loading:** Implementation of `async/await` and `fetch()` for data retrieval.
- [x] **RESTful API:** Developed backend endpoints at `/api/v1/products`.
- [x] **Static Resource Mapping:** Organized handling of styles and product images.
