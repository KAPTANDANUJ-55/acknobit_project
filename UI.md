# Acknobit AI — Website Redesign UI Blueprint & Design System

A comprehensive UI/UX blueprint, visual style guide, wireframe layout map, and component specification document for the redesign of the **Acknobit AI** platform.

---

## 📌 1. Project Overview

* **Project Name:** Acknobit AI Website Redesign
* **Objective:** Transform the existing static site into an interactive, high-converting, dark-themed AI web application. Fix current visual bugs, reduce contact form drop-off rates with a 2-step wizard, and add an integrated Admin Dashboard.

---

## 2. Design System & Style Guide

### A. Color Palette 

| Palette Role | Color Name | Hex Code / Value | Usage |
|---|------------|---------|---|
| **Background Base** | Slate Navy | `#0F172A` | Main page background |
| **Surface / Card** | Dark Steel | `#1E293B` | Card containers & modals |
| **Card Border** | Subtle Glass Edge | `rgba(255, 255, 255, 0.08)` | Glassmorphism borders |
| **Primary Accent** | Electric Royal Blue | `#3B82F6` | Primary buttons, active states, key icons |
| **Secondary Accent** | Emerald Growth | `#10B981` | Gradient highlights & secondary badges |
| **Glow Accent** | Electric Purple | `#1E90FF` | Background glow ambient lights |
| **Text Primary** | mint cream | `#F5FFF`| Headings & primary labels |
| **Text Secondary** | Cool Slate | `#9CA3AF` | Body text, subheadings, captions |
| **Status Success** | Emerald Green | `#10B981` | Success alerts & active indicators |

### B. Typography Scale

* **Font Family:** `Inter`, `Plus Jakarta Sans`, sans-serif
* **Display / Hero Heading (H1):** `3.5rem` / `56px` | Weight: `700 (Bold)` | Line Height: `1.2`
* **Section Heading (H2):** `2.25rem` / `36px` | Weight: `600 (Semi-Bold)` | Line Height: `1.3`
* **Card Heading (H3):** `1.5rem` / `24px` | Weight: `600 (Semi-Bold)` | Line Height: `1.4`
* **Body Text (Regular):** `1.0rem` / `16px` | Weight: `400 (Regular)` | Line Height: `1.6`
* **Caption / Label:** `0.875rem` / `14px` | Weight: `500 (Medium)` | Tracking: `0.05em`

### C. Layout & Grid System

### C. Layout System (FlexBox Container)

* **Desktop Layout:** Responsive Flex Container (`display: flex`, `flex-wrap: wrap`) | Max-Container Width: `1280px` | Flex Gap: `24px` | Multi-column flex basis (`flex: 1 1 calc(33.333% - 24px)`)
* **Tablet Layout:** Adaptive Flex Container (`flex-wrap: wrap`) | Screen Margin: `24px` | Flex Gap: `16px` | 2-Column flex basis (`flex: 1 1 calc(50% - 16px)`)
* **Mobile Layout:** Vertical Flex Stack (`flex-direction: column`) | Screen Margin: `16px` | Flex Gap: `12px` | Full-width flex basis (`flex: 1 1 100%`)

---

##  3. Page Structure 

### PUBLIC HOMEPAGE (`index.html`)

```text
+-----------------------------------------------------------------------------------------------------------------+
|  [Logo] Acknobit AI        Services   Bots   Portfolio   Admin Login  How It Works  Our Works    [Get Started] | 
+-----------------------------------------------------------------------------------------------------------------+
|                                                                                                                 |
|    (Tagline Badge) • AI-POWERED BUSINESS AUTOMATION                                                             |
|                                                                                                                 |
|           Automate Your Business With Intelligent AI                                                            |  
|                                                                                                                 |
|    From smart chatbots to voice assistants - we build 24/7 AI solutions.                                        |  
|                                                                                                                 |
|        [ Start Your Project -> ]      [ Try Live Simulation ]                                                   | 
|                                                                                                                 |
|   +------------------------------------------------------------------------------------------------------------+|
|   |  [INTERACTIVE LIVE CHAT SIMULATION WIDGET]                                |                                 |  
|   |  Namaste! How can I help automate your business today?                    |                                 |
|   |  Quick Prompts: [ "Request Pricing" ] [ "Book Demo" ] [ "Voice Agents" ]  |                                 |
|   +------------------------------------------------------------------------------------------------------------+|
|                                                                                                                 |
|       150+ Projects Delivered    •    98% Satisfaction    •    24/7 Support                                     | 
|                                                                                                                 |
+-----------------------------------------------------------------------------------+                             |
|                                                                                                                 |
|                               CORE SERVICES FLEXBOX                                                             |
|                                                                                                                 |
|   +----------------------+  +------------------+  +--------------------+  +-----------+                         |       
|   |  Website Development |  |  AI Automation   |  | Chatbot Development|  | Voice AI  |                         |       
|   |  Fast & Modern       |  |  [MOST POPULAR]  |  |  WhatsApp/Tele     |  |  Calls    |                         |            
|   |  [ Get Quote ]       |  |  [ Get Quote ]   |  |  [ Get Quote ]     |  | [ Quote ] |                         |      
|   +----------------------+  *------------------+  +--------------------+  +-----------+                         |      
|                                                                                                                 |
+-----------------------------------------------------------------------------------+                             |
|                                                                                                                 |
|                          INTERACTIVE AI ROI CALCULATOR                                                          |
|                                                                                                                 |
|   Select Team Size: [ ========o==== ] 25 Employees                                                              |
|   Manual Hours/Day: [ ======o====== ] 4 Hours                                                                   |
|                                                                                                                 |
|   -----------------------------------------------------------------------------                                 |
|   Estimated Time Saved: 300 Hours / Month  |  Cost Efficiency Gain: 65%                                         | 
|   -----------------------------------------------------------------------------                                 |
|                                                                                                                 |
+----------------------------------------------------------------------------------------------------------------+|
|                                                                                                                 |
|                           DYNAMIC PORTFOLIO SHOWCASE                                                            |
|                                                                                                                 |
|      Filter Tabs:  [ ALL ]  [ WhatsApp Bots ]  [ AI Agents ]  [ Web Dev ]                                       | 
|                                                                                                                 |
|   +--------------------------+  +--------------------------+                                                    |
|   | [ Image / Video Demo ]   |  | [ Image / Video Demo ]   |                                                    |
|   | E-commerce Support Bot   |  | Real Estate Voice Agent  |                                                    |
|   | Client: RetailHub        |  | Client: PropTech         |                                                    |
|   | [ Watch Demo Modal -> ]  |  | [ Watch Demo Modal -> ]  |                                                    |
|   +--------------------------+  +--------------------------+                                                    |
|                                                                                                                 |
+----------------------------------------------------------------------------------------------------------------+|
|                                                                                                                 |
|                         2-STEP LEAD GENERATION WIZARD                                                           |
|                                                                                                                 |
|   Step 1 of 2: Basic Info                          Step 2 of 2: Project Scope                                   |
|   +---------------------------------------+        +--------------------------+                                 |
|   | Full Name *   | Phone Number *        |   --   | Budget Range [ Select ]  |                                 |
|   | Email *       | Service Interested    |        | Timeline     [ Select ]  |                                 |
|   +---------------------------------------+        | Tell us about project... |                                 |
|              [ Next Step -> ]                      +--------------------------+                                 |
|                                                            [ Submit Inquiry ]                                   |
|                                                                                                                 |
+----------------------------------------------------------------------------------------------------------------+|
|  Footer: Logo, Service Links, Social Handles, Copyright 2026.                                                   |
+----------------------------------------------------------------------------------------------------------------+|
```


## 4. Admin Panel UI

### Admin Login Page

```text         
+-----------------------------------------------------------------------------------------------------------------+
|  [Logo] Acknobit AI       Bots     How It Works  Our Works                                                      | 
+-----------------------------------------------------------------------------------------------------------------+                                                                        |
|                             +-----------------------+                                                           |
|                             |    ACKNOBIT ADMIN     |                                                           |
|                             |                       |                                                           |
|                             |  Username: [       ]  |                                                           |
|                             |  Password: [       ]  |                                                           |                        
|                             |    [ Secure Login ]   |                                                           |
|                             +-----------------------+                                                           |
+-----------------------------------------------------------------------------------------------------------------+                                                      
|                 Footer: Logo, Service Links, Social Handles, Copyright 2026.                                    |                                                              |
+-----------------------------------------------------------------------------------------------------------------+
```

## 4. Admin DashBoard UI

### Admin DashBoard Page

```text 
+-----------------------------------------------------------------------------------+
| logo acknobit | Acknobit Admin | [ Dashboard ]  [ Leads ]  [ Portfolio Manager ]   | (Admin) Logout |
+-----------------------------------------------------------------------------------+
|                                                                                   |
|  ANALYTICS OVERVIEW                                                               |
|  +-------------------+  +-------------------+  +-------------------+              |
|  | Total Leads: 48   |  | Pending: 12       |  | Closed Deals: 36  |              |
|  +-------------------+  +-------------------+  +-------------------+              |
|                                                                                   |
|  CLIENT INQUIRIES / LEADS TABLE                                                   |
|  Filter Status: [ ALL | NEW | CONTACTED | CLOSED ]                                 |
|  +----+--------------+-------------------+---------------+-----------+----------+ |
|  | ID | Client Name  | Service           | Budget        | Status    | Action   | |
|  +----+--------------+-------------------+---------------+-----------+----------+ |
|  | 01 | Sample Client 1 | AI Automation     | ₹25k - ₹50k   | [NEW v]   | [Delete] | |
|  | 02 | Alex Smith      | WhatsApp Bot      | $1000+        | [CLOSED v]| [Delete] | |
|  +----+--------------+-------------------+---------------+-----------+----------+ |
|                                                                                   |
|  PORTFOLIO MANAGER                                                                |
|  [ + Add New Portfolio Item ]                                                     |
|                                                                                   |
|  +--------------------------------+  +--------------------------------+          |
|  | E-commerce Support Bot         |  | Real Estate Voice Agent        |          |
|  | Category: WHATSAPP_BOT         |  | Category: VOICE_AGENT          |          |
|  | [ Edit ]  [ Delete ]           |  | [ Edit ]  [ Delete ]           |          |
|  +--------------------------------+  +--------------------------------+          |
|                    Footer: Logo, Service Links, Social Handles, Copyright 2026.                                                                    |
+-----------------------------------------------------------------------------------+
```

## 5. Detailed Features Breakdown

### 1. Interactive Live Chat Simulation Widget (Hero Section)
* **Description:** A real-time interactive chatbot preview embedded directly within the hero section.
* **How It Works (UX):**
    * Visitors can select quick-action prompt buttons.
    * The widget displays an animated typing indicator (`...`) .
* **Business Benefit:** Gives prospective clients an instant hands-on demo of Acknobit's AI bot capabilities without requiring signup or contact information.

---

### 2. Interactive AI ROI & Time-Saved Calculator
* **Description:** A slider-based interactive tool allowing B2B clients to estimate operational time and cost savings using Acknobit's AI automations.
* **How It Works (UX):**
    * **Slider 1 (Input):** Select Team Size (1 to 100+ Employees).
    * **Slider 2 (Input):** Select Manual Repetitive Hours spent daily (1 to 8 Hours).
    * **Dynamic Output Display:** Real-time JavaScript calculations compute:
        * *Estimated Hours Saved / Month*
        * *Cost Efficiency Increase (%)*
* **Business Benefit:** Quantifies value immediately for decision-makers, significantly speeding up lead conversion.

---

### 3. Dynamic Filterable Portfolio Showcase ("Our Works")
* **Description:** An interactive showcase gallery where prospective clients can explore real case studies, live bot demos, and industry-specific proof of work.
* **How It Works (UX):**
    * **Multi-Category Filters:** Visitors can filter showcase items by **Company/Industry Type** (e.g., *E-commerce, Real Estate, Healthcare, Finance*) as well as **Bot Type** (e.g., *WhatsApp Bots, Voice Assistants, AI Agents*).
    * **Dynamic Filtering:** Selecting a filter updates the project cards instantly without page reloads using JavaScript (`fetch()` API).
    * **Impact & Benefit Metrics:** Each project card prominently displays measurable results and benefits achieved (e.g., *"Saved 120+ hours/month"*, *"40% increase in qualified leads"*, *"Automated 85% support queries"*).
    * **Interactive Demo Modal:** Clicking on any project opens a Lightbox Modal displaying live demo previews, workflow diagrams, and client testimonials.
* **Business Benefit:** Eliminates client skepticism by showcasing tangible proof-of-work, allowing potential leads to see exact benefits achieved by businesses in their specific industry.
 ---

### 4. Admin Lead Tracking & Status Management System
* **Description:** A dedicated dashboard view inside the internal Admin Portal (`admin-dashboard.html`) for managing client inquiries.
* **How It Works (UX):**
    * Incoming client inquiries are populated in real-time into a clean, searchable data table.
    * Admins can update lead conversion stages via a dropdown selector (`NEW` → `IN_REVIEW` → `CONTACTED` → `CLOSED`).
    * Integrates with Spring Mail Sender for instant email alerts upon new form submissions.

---

### 5. Admin Portfolio Manager (Zero-Code CRUD System)
* **Description:** A content management interface within the Admin Portal for publishing and editing showcase items.
* **How It Works (UX):**
    * Admins can upload new project entries (*Title, Category, Demo Link, Image URL, Featured Flag*).
    * Provides inline controls to edit details or delete outdated portfolio items from the live website.
* **Business Benefit:** Allows non-technical team members to keep the portfolio up to date without requiring developer intervention or code deployment.
