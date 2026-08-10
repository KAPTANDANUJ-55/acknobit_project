# Acknobit Ai - Website Redesign & System Blueprint

#### An blueprint and technical architecture for redesigning the **Acknobit Ai**

#### Built With a **HTML / CSS / Vanilla JS** Frontend and Backend **Java SpringBoot 4.1.0** RESTful backend.

## 📍 Project Overview(blueprint)

 ---

#### Acknobit Ai is and AI Automation and Bot Development firm. The goal of redesign the website is to eliminate the existing bugs and to transform the existing static website into a modern , dynamic , and high converting platform featuring interactive elements(like live chat simulation ,Admin Panel,Dynamic portfolio filtering , etc)

 ---

## ⚙️ Tech Stack

| Layer               | Technology                                                                                  |
|---------------------|---------------------------------------------------------------------------------------------|
| **Frontend**        | HTML, Modern CSS, Vanilla JavaScript (Fetch API)                                            |
| **Backend**         | Java 25, Spring Boot 4.1.0 (Spring Web, Spring Data JPA, Spring Validation, JavaMailSender) |
| **Database**        | MySQL                                                                                       |
| **Tools & Testing** | Maven, Git/GitHub, Postman, Docker                                                          |

 ---

## System Architecture  & Database Schema

### 1. Database ('schema.sql')
 ```sql 
    create database IF NOT EXISTS acknobit.db;
    USE acknobit.db;
    
    
    -- Admin Table
    create table admins(
       id BIGINT AUTO_INCREMENT primary_key,
       username varchar(150) UNIQUE not null,
       password VARCHAR(255) NOT NULL, -- BCrypt Encrypted
       email VARCHAR(100) NOT NULL,
       role VARCHAR(20) DEFAULT 'ROLE_ADMIN',
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
    
   -- client inquiries table
   
     create table cTable(
            id BIGINT AUTO_INCREMENT primary key,
            full_name varchar(100) NOT NULL,  
            phone_number VARCHAR(20) NOT NULL,
            email VARCHAR(100) NOT NULL,
            business_name VARCHAR(100),
            company_size VARCHAR(50),
            service_interested VARCHAR(100) NOT NULL,
            budget_range VARCHAR(50),
            timeline VARCHAR(50),
            project_details TEXT,
            status VARCHAR(20) DEFAULT 'NEW', -- NEW, IN_REVIEW, CONTACTED, CLOSED
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
     );
     
     -- 3. Portfolio table for filterable projects and client demos
     create table portfolios (
            id BIGINT AUTO_INCREMENT PRIMARY KEY,
            title VARCHAR(150) NOT NULL,
            category VARCHAR(50) NOT NULL, -- e.g., 'WHATSAPP_BOT', 'AI_AUTOMATION', 'VOICE_AGENT'
            description TEXT NOT NULL,
            client_name VARCHAR(100),
            demo_url VARCHAR(255),
            image_url VARCHAR(255),
            is_featured BOOLEAN DEFAULT FALSE,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    
 ```


# Complete RESTful Specs

## 1. submit client inquiries
* Endpoint : POST /acknobit/client/leads
* Description : It will send the notification of filled up form via java mail sender
* Sample JSON:
* ```json
  [{
       "fullName": "YOUR_FULL_NAME",
       "phoneNumber": "YOUR_PHONE_NUMBER",
        "email": "example@example.com",
        "businessName": "YOUR_BUSINESS_NAME",
         "companySize": "WRITE_YOUR_COMPANY_SIZE",
         "serviceInterested": "YOUR_INTEREST",
         "budgetRange": "YOUR_BUDGET_RANGE",
          "timeline": "WRITE_YOUR_TIMELINE",
           "projectDetails": "ADD_YOUR_FULL_PROJECT_DETAILS"
  }]
  ```
 * ```
   Responses: 201 Created : data sucessfully saved in mySQL
             400 Bad Request: Validation failure
   ```



 ---
## 2. fetch public portfolios
* Endpoint : GET /acknobit/client/portfolios

* Description : Fetches list of live bots and showcase projects for site visitors.

* Query Params : ?category=WHATSAPP_BOT (Optional)

* Sample Response:
 ```json
[
  {
    "id": 1,
    "title": "E-commerce Support Bot",
    "category": "WHATSAPP_BOT",
    "description": "Automated WhatsApp support agent with automated tracking & FAQs.",
    "clientName": "RetailHub",
    "demoUrl": "[https://demo.acknobit.com/whatsapp-bot](https://demo.acknobit.com/whatsapp-bot)",
    "imageUrl": "[https://acknobit.com/images/whatsapp-bot.jpg](https://acknobit.com/images/whatsapp-bot.jpg)",
    "isFeatured": true
  }
]
```
* ```Responses: 200 OK : Portfolios fetched successfully```

 ---
## 3. admin login authentication
* Endpoint : POST /acknobit/auth/login

* Description : Validates admin credentials and returns JWT bearer token.

Sample JSON:
  ```json
{
"username": "admin_acknobit",
"password": "SuperSecretPassword123"
}
```

``` 
Sample Responses:
  {
  "success": true,
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1p...",
  "username": "admin_acknobit",
  "role": "ROLE_ADMIN"
}
  
  ```  

* ```
  Responses: 200 OK : Auth successful 401 Unauthorized : Invalid username or password


```