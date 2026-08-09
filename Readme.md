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


