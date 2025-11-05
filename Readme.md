One short intro: “DeltaX FAQ Assistant – Spring Boot + PostgreSQL backend API for managing FAQs.”

Purpose: mention categories, tags, users, and the AI answer suggestion endpoint.

## 1 Tech Stack
Java 17
Spring Boot 3.x
PostgreSQL
Hibernate / JPA
Maven

## 2 PROJECT STRUCTURE
src/main/java/com/delta/delta_faq_assistant_assignment/
controller/ REST Controllers (FAQ, User, Category, Tag)
entity/ Entities (FaqBO, CategoryBO, TagBO, UserBO)
repository/ Spring Data JPA Repositories
service/ Service Interfaces
service/impl/ Service Implementations
DeltaFaqAssistantAssignmentApplication.java
src/main/resources/
application.properties
schema.sql



### 3 Setup Instructions

Clone the repository
git clone https://github.com/
<your-username>/deltax-faq-assistant-backend.git
cd deltax-faq-assistant-backend

Create the PostgreSQL database
CREATE DATABASE faq_assistant;

Update application.properties
spring.datasource.url=jdbc:postgresql://localhost:5433/faq_assistant
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.cache.type=simple

Run the application
mvn spring-boot:run

The server runs at http://localhost:8082

```
### 4 API Endpoints
  ## 1. USER API (/api/users)

POST /api/users
GET /api/users
GET /api/users/{id}
DELETE /api/users/{id}

Example:
POST /api/users
{
"name": "Vijay Reddy",
"email": "vijayreddy@example.com
"
}

## 2. CATEGORY API (/api/categories)

POST /api/categories
GET /api/categories

Example:
{
"name": "Billing"
}


## 3. TAG API (/api/tags)

POST /api/tags
GET /api/tags

Example:
{
"name": "Backend"
}


## 4. FAQ API (/api/faqs)
POST /api/faqs
GET /api/faqs
GET /api/faqs/search?q={keyword}
PUT /api/faqs/{id}
DELETE /api/faqs/{id}

Example:
Request:
{
"question": "What does the DeltaX platform do?",
"answer": "DeltaX provides a unified platform to plan, buy, optimize, and analyze digital media campaigns. It supports automation, data integration, real-time bidding, and performance attribution to improve ROI.",
"categoryId": 3,
"createdById": 1,
"tagIds": [4, 5]
}
 Response:
{
"id": 1,
"question": "What does the DeltaX platform do?",
"answer": "DeltaX provides a unified platform to plan, buy, optimize, and analyze digital media campaigns. It supports automation, data integration, real-time bidding, and performance attribution to improve ROI.",
"category": {
"id": 3,
"name": "Billing"
},
"createdBy": {
"id": 1,
"name": "Vijay Reddy",
"email": "vijayreddy@example.com",
"createdOn": "2025-11-05T19:54:10.460484Z",
"modifiedOn": "2025-11-05T19:54:10.460484Z"
},
"tags": [
{
"id": 5,
"name": "Refund"
},
{
"id": 4,
"name": "Invoice"
}
],
"createdOn": "2025-11-05T20:16:08.071162Z",
"modifiedOn": "2025-11-05T20:16:08.071162Z"
}
```

## Cross-Origin Resource Sharing (CORS)

To allow frontend apps to call APIs hosted elsewhere, controllers include:
@CrossOrigin(origins = "*")

This allows requests from all origins.



### API Testing Detials
Below are sample screenshots from Postman, showing working API responses for each endpoint:

<img width="1412" height="908" alt="image" src="https://github.com/user-attachments/assets/fed38505-12a9-4639-bdd2-eee459eb7be2" />
<img width="1442" height="900" alt="image" src="https://github.com/user-attachments/assets/160f10c7-d889-401e-a817-fa6b2c4e6018" />
<img width="1438" height="925" alt="image" src="https://github.com/user-attachments/assets/94f40d1f-78d6-4f69-82a6-c3dfcbcce66b" />


