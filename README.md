## Library Management System

# Project Overview

The Library Management System is a software application designed to manage the activities of a library efficiently. The system allows users to handle book categories, books, library members, borrowing transactions, and book returns while applying fines for overdue books.

# Business Requirements

The system will include the following functionalities:

- Record details of book categories.

- Record details of all books.

- Maintain records of all members and borrowings.

- Allow members to return books within the due date.

- Track due dates for borrowed books.

- Apply fines for overdue book returns.

# System Functionalities

1. User Login – Secure authentication for system access.

2. Manage Book Categories – Create, Read, Update, and Delete (CRUD) operations.

3. Manage Books – CRUD operations for book details.

4. Manage Members – CRUD operations for member information.

5. Manage Borrowing Transactions – Issue books and track borrowing details.

6. Process Returns & Apply Fines – Handle book returns and apply fines for late submissions.

# Implementation Details

- Programming Language: Java

- Database: MySQL

- User Interface: JavaFX (Recommended) or Java Swing

- Database Connectivity: Hibernate (Recommended) or JDBC

- Architecture: Layered Architecture (Separation of concerns for better maintainability)

- Version Control: GitHub repository with feature branches for development and merging with the main branch after feature completion.

## Setup Instructions

# Prerequisites

✅Install JDK 11 or higher

✅Install MySQL Server and create a database

✅Install Maven (for dependency management)

✅Install Git (for version control)

# Steps to Run the Project

Clone the repository:

```git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
```

Configure the database in application.properties (if using Hibernate) or database-config.xml (if using JDBC).

Build the project using Maven:

```
mvn clean install
```

Run the application:

java -jar target/library-management-system.jar

Login using the default admin credentials (if applicable).

Start managing books, categories, members, and transactions.
