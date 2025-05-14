# JDBC Test Automation Framework with Sakila Database

This project is a lightweight test automation framework built using **Java**, **Cucumber**, and **JDBC** for validating data and metadata in the `sakila` MySQL sample database. It demonstrates how to write database-driven tests for schema verification and data validation.

---

## 📦 Tech Stack

- **Java 11+**
- **Maven**
- **Cucumber**
- **JDBC**
- **JUnit**
- **MySQL (Sakila Database)**

---

## 🧪 What’s Tested?

- Data-level tests on the `customer` table
- Metadata validation (column types, nullability, primary key)
- Table existence
- Integration of BDD with database assertions

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/orionincHasan/Sakila_database-JDBC.git
cd Sakila_database-JDBC

### 2. Configure Database
***Update your credentials in DBUtils.java:
DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "your_password");

***Make sure the Sakila database is imported and running in your local MySQL.

### 3. Run Tests
mvn test


📊 Reports
Basic HTML report: target/cucumber-reports.html

Optional JSON report: target/cucumber.json

You can enhance reports using Maven Cucumber Reporting or ExtentReports.

📌 Notes
Ensure your local MySQL service is running.

Tests assume the Sakila database is unmodified.

You can add more table or integration tests similarly.





