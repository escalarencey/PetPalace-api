# Laboratory 9: Securing the API with Sessions & Input Validation
**Members:** Rence A. Escala & Lyza Atencio  
**Course/Section:** BSIT 2B - University of Eastern Philippines

## 🛡️ Security Architecture
In this laboratory, we implemented **Session-Based Authentication** using Spring Security. 
- **Mechanism:** Unlike stateless JWTs, we use HTTP Sessions. Upon successful login, the server creates a session and sends a `JSESSIONID` cookie to the client.
- **CSRF Protection:** Configured to ensure that form submissions are secure against cross-site request forgery.
- **Password Hashing:** All user passwords are encrypted using `BCryptPasswordEncoder` before being stored in the MySQL database.

## 🛠️ Validation Rules
We applied strict **Bean Validation** constraints on our Data Transfer Objects (DTOs) and Entities:
- **Product Name:** Must not be blank (`@NotBlank`).
- **Product Price:** Must be a positive value (`@Positive`).
- **User Credentials:** Username and Password require a minimum length of 8 characters (`@Size`).

## 🚀 API Reference
| Endpoint | Method | Authentication | Access Level |
| :--- | :--- | :--- | :--- |
| `/api/v1/auth/register` | POST | Public | All |
| `/login` | POST | Public | All |
| `/api/v1/products` | GET | Public | All |
| `/api/v1/products` | POST | Authenticated | USER / ADMIN |
| `/api/v1/products/{id}` | DELETE | Authenticated | ADMIN ONLY |

## 🧪 Testing Proofs (Image Demo Guide)
1. **Successful Login:** Observe the `JSESSIONID` cookie in the browser's DevTools under the Application/Cookies tab.
2. **Access Control:** Attempting to delete a product as a regular user returns a `403 Forbidden` status.
3. **Validation:** Sending a negative price in a POST request returns a structured JSON error handled by our `GlobalExceptionHandler`.
