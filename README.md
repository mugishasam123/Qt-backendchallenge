# E - Invoicing System using Microservices

## Overview

This project implements a E - Invoicing system using microservices architecture. The system consists of three main microservices: UserService, CustomerService, and InvoiceService. Additionally, Eureka is used for service discovery, and an API Gateway is implemented to manage API requests.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Cloud
- API Gateway (Spring Cloud Routing)
- MongoDB 
- Microservices Architecture

## Project Structure

- `service-1`: User Service
- `service-2`: Customer Service
- `service-3`: Invoice Service
- `service-4`: Server configuration
- `api-gateway`: API Gateway

### UserService

The `UserService` microservice is responsible for managing user-related operations within the Invoicing system. It focuses on user registration, authentication, and profile management.

#### Features:

- **User Registration:**
  - Endpoint: `POST /api/v1/auth/signup`
  - Allows new users to register by providing necessary details.
  - Utilizes web security to ensure secure registration.

- **User Authentication:**
  - Endpoint: `POST /api/v1/auth/signin`
  - Implements web security and JWT token authentication for secure user login.
  - Generates a JWT token upon successful authentication.

- **Get User Details:**
  - Endpoint: `GET /api/user/profile`
  - Retrieves user details based on the provided user ID.

#### Security:

The `UserService` employs web security to safeguard user registration and login processes. JWT token authentication is implemented to ensure secure communication and user authentication. This ensures that only authorized users can access the system's functionalities.

#### Usage:

- This microservice is an essential component for user management in the overall Invoicing Management system.
- It provides the necessary endpoints for user registration, authentication, and fetching user details.

### CustomerService

The `CustomerService` microservice is dedicated to managing customers within the Invoicing Management system. It facilitates the crud operation of customers.

#### Features:

- **Create a New Customer (Admin Only):**
  - Endpoint: `POST /api/v1/customers`
  - Allows administrators to create new customers by providing customer details.
  - Only users with admin privileges can access this endpoint.

- **Get customer Details:**
  - Endpoint: `GET /api/v1/customers`
  - Retrieves detailed information about a specific customer based on the provided customer ID.

- **Update customer details:**
  - Endpoint: `PUT /api/v1/customers`
  - Permits administrators to update customer details.
  - Requires role privileges for access.

- **get all  customers:**
  - Endpoint: `GET /api/v1/customers`
  - anyone is allowed to call this endpoint.
  - Requires  no role privileges for access.

- **Delete  customer:**
  - Endpoint: `DELETE /api/v1/customers`
  - users with role based privilege is allowed to call this endpoint.
  - Requires  role privileges for access.




#### Security:

- all crud operations except viewing all customers are restricted to users with role based privileges.
- This ensures that only authorized administrators can create create and update customers.

#### Usage:

- The `Customer Service` plays a vital role in customer management within the overall incoice Management system.
- It offers endpoints for creating customers, updating customers, and fetching detailed customer information.
- Admin privileges are required for customer creation and update, emphasizing role-based access control.

### InvoiceService

The `InvoiceService` microservice is dedicated to handling the creation of invoices within the Invoice Management system. It provides functionality for users to submit their completed Invoices and retrieve details about those invoices.

#### Features:

- **Create a New Invoice (Admin Only):**
  - Endpoint: `POST api/v1/invoices`
  - Allows administrators to create new Invoice by providing Invoice details.
  - Only users with admin privileges can access this endpoint.

- **Get Invoice Details:**
  - Endpoint: `GET api/v1/invoices`
  - Retrieves detailed information about a specific Invoice based on the provided Invoice ID.

- **Update Invoice details:**
  - Endpoint: `PUT api/v1/invoices`
  - Permits administrators to update Invoice details.
  - Requires role privileges for access.

- **get all  Invoice:**
  - Endpoint: `GET api/v1/invoices`
  - anyone is allowed to call this endpoint.
  - Requires  no role privileges for access.

- **Delete  Invoice:**
  - Endpoint: `DELETE api/v1/invoices`
  - users with role based privilege is allowed to call this endpoint.
  - Requires  role privileges for access.

#### Security:

- all crud operations except viewing all invoices are restricted to users with role based privileges.
- This ensures that only authorized administrators can create create and update invoices.

#### Usage:

- The `Invoice Service` plays a vital role in invoice management within the overall invoice Management system.
- It offers endpoints for creating invoices, updating invoices, and fetching detailed invoices information.
- Admin privileges are required for customer creation and update, emphasizing role-based access control.

### Eureka Server Configuration

The `Eureka Server` is a crucial component that enables service discovery within the invoice Management system. It efficiently manages the UserService, customerService, and invoiceService, allowing seamless communication between microservices.

#### Service Discovery:

- **Purpose:**
  - Eureka Server facilitates service discovery, allowing microservices to register and discover each other dynamically.

- **Usage:**
  - Each microservice (UserService, customerService, invoiceService) registers itself with the Eureka Server during startup.
  - Other microservices can discover and communicate with registered services using Eureka's service registry.

### OpenFeign for Microservice Communication

The `OpenFeign` library is employed to simplify communication between microservices in the invoice Management system. It offers a declarative way to define web service clients.

#### Communication Features:

- **Declarative REST Clients:**
  - OpenFeign allows the definition of declarative REST clients using annotations, reducing boilerplate code.

- **Microservice Communication:**
  - Microservices, such as the API Gateway, can utilize OpenFeign to communicate with other services seamlessly.

#### Usage:

- Microservices can define Feign clients, specifying the target service and its API endpoints using annotated interfaces.
- This simplifies the communication process, enhancing the maintainability of the system.

### API Gateway

The `API Gateway` serves as the single entry point for the invoice Management system, directing and managing requests to the corresponding microservices. This component is implemented using Spring Cloud Gateway for efficient routing.

#### Purpose:

- **Routing Requests:**
  - Routes incoming requests to the appropriate microservices based on predefined patterns.

- **Centralized Entry Point:**
  - Provides a centralized entry point for client applications to interact with the system.

#### Configuration:

- **Route Configuration:**
  - Utilizes Spring Cloud Gateway to define routes for UserService, customerService, and invoiceService.
  - Enables seamless communication between microservices.

#### Security:

- **Endpoint Protection:**
  - Implements security measures to protect API endpoints.
  - Enforces authentication and authorization as configured in the microservices.

#### Usage:

- **Single Port Access:**
  - The API Gateway is configured to run on a single port (e.g., 8080).
  - Microservices communicate through the gateway using defined routes.

- **Simplified Communication:**
  - Enhances the simplicity of communication between client applications and microservices.
  - Utilizes Spring Cloud Gateway's flexibility for routing and load balancing.



## Getting Started

Welcome to the Inoice Management microservices project! Follow these steps to set up and run the project on your local machine.

### Step 1: Clone the Project

1. Open a terminal on your computer.

2. Clone the project repository by running the following command:
   ```bash
   git clone [<repository-url>](https://github.com/mugishasam123/Qt-backendchallenge)
   cd Qt-backendchallenge

### Step 2: Run Eureka Server

1. Navigate to the Eureka directory:.

2. Start the Eureka Server using the following command::
   ```bash
   cd EurekaServerConfiguration
   ./gradlew bootRun
3.Open your web browser and visit http://localhost:8081 to access the Eureka Server dashboard.
### Step 3: Run Microservices
For each microservice (UserService, CustomerService, InvoiceService), navigate to its directory and run it. Here's an example for UserService:
1. Navigate to the Eureka directory:.
2. Start the Eureka Server using the following command::
   ```bash
   cd UserService
   ./gradlew bootRun
3.Repeat the process for TaskService and TaskSubmissionService.
### Step 4: Run API Gateway
For each microservice (UserService, CustomerService, InvoiceService), navigate to its directory and run it. Here's an example for UserService:
1. Navigate to the API Gateway directory:
2. Start the API Gateway using the following command:
   ```bash
   cd APIGateway
   ./gradlew bootRun
3.Repeat the process for CustomerService and InvoiceSubmissionService.

### Step 5: Verify Local Setup
Open your web browser and visit http://localhost:8089 to access the API Gateway.
You've successfully set up the Task Management microservices project on your local machine! Feel free to explore and test the functionalities.
Feel free to copy and paste this version into your README file. Let me know if there's anything else I can help you with!
## Contributions

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
