# 📚 BookVault - Book Store Management System

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Thymeleaf-3.x-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white"/>
  <img src="https://img.shields.io/badge/Bootstrap-5.3-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"/>
</p>

<p align="center">
  A full-stack web application for managing a book store — built with Spring Boot, JPA, Thymeleaf, and MySQL.
</p>

---

## 🖥️ Project Overview

**BookVault** is a professional Book Store Management System developed as a Final Year Internship Project. It allows users to manage a complete book catalog — register books, search, edit, delete, and maintain a personal reading list — all through a modern dark-themed web interface.

---

## ✨ Features

| Feature | Description |
|--------|-------------|
| 📖 **Book Registration** | Add new books with title, author, and price |
| 🔍 **Smart Search** | Search books by title or author in real-time |
| ✏️ **Edit Books** | Update existing book details |
| 🗑️ **Delete Books** | Remove books from the catalog with confirmation |
| 🔖 **My Book List** | Save books to a personal reading collection |
| ❌ **Remove from List** | Remove books from personal collection |
| 📊 **Live Stats Dashboard** | Home page shows total books & collection count |
| ✅ **Flash Messages** | Success notifications after every action |
| 📱 **Responsive Design** | Works on desktop, tablet, and mobile |

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Java 21, Spring Boot 3.2.5 |
| **Persistence** | Spring Data JPA, Hibernate |
| **Database** | MySQL 8.0 |
| **Frontend** | Thymeleaf, HTML5, CSS3 |
| **UI Framework** | Bootstrap 5.3 |
| **Icons** | Font Awesome 6.5 |
| **Fonts** | Google Fonts (Playfair Display, DM Sans) |
| **Build Tool** | Maven |

---

## 📁 Project Structure

```
BookStoreManagement/
├── src/
│   └── main/
│       ├── java/com/bookmanagement/
│       │   ├── BookStoreManagementApplication.java   # Entry point
│       │   ├── controller/
│       │   │   ├── BookController.java               # Main book routes
│       │   │   └── MyBookListController.java         # My list routes
│       │   ├── entity/
│       │   │   ├── Book.java                         # Book entity
│       │   │   └── MyBookList.java                   # My book list entity
│       │   ├── repository/
│       │   │   ├── BookRepository.java               # JPA + search query
│       │   │   └── MyBookRepository.java
│       │   └── service/
│       │       ├── BookService.java
│       │       └── MyBookService.java
│       └── resources/
│           ├── templates/
│           │   ├── home.html                         # Dashboard / landing page
│           │   ├── bookList.html                     # All books + search
│           │   ├── bookRegister.html                 # Add new book form
│           │   ├── bookEdit.html                     # Edit book form
│           │   └── myBooks.html                      # Personal reading list
│           └── application.properties
└── pom.xml
```

---

## ⚙️ Setup & Installation

### Prerequisites

- Java 21+
- Maven 3.8+
- MySQL 8.0+
- IDE (Eclipse IDE)

### Step 1 — Clone the Repository

```bash
git clone https://github.com/yourusername/BookStoreManagement.git
cd BookStoreManagement
```

### Step 2 — Create the MySQL Database

```sql
CREATE DATABASE book;
```

### Step 3 — Configure Database Credentials

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/book?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
```

### Step 4 — Run the Application

```bash
mvn spring-boot:run
```

Or run `BookStoreManagementApplication.java` directly from your IDE.

### Step 5 — Open in Browser

```
http://localhost:8080
```

> Tables are auto-created by Hibernate on first run (`spring.jpa.hibernate.ddl-auto=update`).

---

## 🗺️ Application Routes

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/` | Home / Dashboard |
| GET | `/available_books` | View all books |
| GET | `/available_books?keyword=xyz` | Search books |
| GET | `/book_register` | New book form |
| POST | `/save` | Save / update a book |
| GET | `/editBook/{id}` | Edit book form |
| GET | `/deleteBook/{id}` | Delete a book |
| GET | `/mylist/{id}` | Add book to My List |
| GET | `/my_books` | View My Book List |
| GET | `/deleteMyList/{id}` | Remove from My List |

## 👨‍💻 Developer

**Gurunath Someshwar Mule**
B.Tech Computer Engineering

This project is developed for educational purposes as part of a Final Year Internship.

---

<p align="center">Built with ❤️ using Spring Boot & Thymeleaf</p>
