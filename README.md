# Laboratory 7: EcommerceApi (Pet Palace)

## [span_11](start_span)Project Overview[span_11](end_span)
This is a RESTful API backend for the Pet Palace e-commerce project. [span_12](start_span)It implements full CRUD operations for product management using Spring Boot and in-memory data storage[span_12](end_span).

## [span_13](start_span)Student Information[span_13](end_span)
* **Name:** Rence A. Escala
* **Section:** BSIT - 2b
* **[span_14](start_span)[span_15](start_span)Partner:** Lyza Atencio (Pair Programming Task)[span_14](end_span)[span_15](end_span)

## [span_16](start_span)[span_17](start_span)Setup and Running Instructions[span_16](end_span)[span_17](end_span)
1. Clone the repository.
2. Ensure Java 17 and Maven are installed.
3. Run the application using the command: `./mvnw spring-boot:run`.
4. The server will start at `http://localhost:8080`.

## [span_18](start_span)[span_19](start_span)API Endpoint Reference[span_18](end_span)[span_19](end_span)
| Method | Path | Description | [span_20](start_span)Expected Status[span_20](end_span) |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/v1/products` | [span_21](start_span)Retrieve all products[span_21](end_span) | 200 OK |
| **GET** | `/api/v1/products/{id}` | [span_22](start_span)Find product by ID[span_22](end_span) | 200 OK / 404 |
| **GET** | `/api/v1/products/filter?filterType=X&filterValue=Y` | [span_23](start_span)Filter products[span_23](end_span) | 200 OK |
| **POST** | `/api/v1/products` | [span_24](start_span)[span_25](start_span)Create new product[span_24](end_span)[span_25](end_span) | 201 Created |
| **PUT** | `/api/v1/products/{id}` | [span_26](start_span)[span_27](start_span)Replace entire product[span_26](end_span)[span_27](end_span) | 200 OK |
| **DELETE** | `/api/v1/products/{id}` | [span_28](start_span)[span_29](start_span)Remove a product[span_28](end_span)[span_29](end_span) | 204 No Content |

## [span_30](start_span)Known Limitations[span_30](end_span)
* **[span_31](start_span)[span_32](start_span)In-memory Storage:** All data is stored in a `List<Product>` and will reset when the server restarts[span_31](end_span)[span_32](end_span).
