# Laboratory 7: EcommerceApi (Pet Palace)

## Project Overview
This is a RESTful API backend for the Pet Palace e-commerce project. It implements full CRUD operations for product management using Spring Boot and in-memory data storage.

## Student Information
* **Name:** Rence A. Escala
* **Section:** BSIT - 2b
* **Partner:** Lyza Atencio (Pair Programming Task)

## Setup and Running Instructions
1. Clone the repository.
2. Ensure Java 17 and Maven are installed.
3. Run the application using the command: `./mvnw spring-boot:run`.
4. The server will start at `http://localhost:8080`.

## API Endpoint Reference
| Method | Path | Description | Expected Status |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/v1/products` | Retrieve all products | 200 OK |
| **GET** | `/api/v1/products/{id}` | Find product by ID | 200 OK / 404 |
| **GET** | `/api/v1/products/filter?filterType=X&filterValue=Y` | Filter products | 200 OK |
| **POST** | `/api/v1/products` | Create new product | 201 Created |
| **PUT** | `/api/v1/products/{id}` | Replace entire product | 200 OK |
| **DELETE** | `/api/v1/products/{id}` | Remove a product | 204 No Content |

## Known Limitations
* **In-memory Storage:** All data is stored in a `List<Product>` and will reset when the server restarts.
