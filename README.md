# Bank Management System

![Bank Management System UI](screenshots/main_ui.png)

A Java and MySQL based application for managing bank operations with an intuitive graphical interface.

## ✨ Features
- **Account Management**: Create, view, update, and delete bank accounts
- **Transaction Processing**: Handle deposits, withdrawals, and fund transfers
- **User Authentication**: Secure login system for bank employees
- **Reporting**: Generate account statements and transaction history
- **Customer Management**: Maintain comprehensive customer records

## 🛠️ Prerequisites
- [XAMPP](https://www.apachefriends.org/download.html) (for MySQL database)
- [Apache NetBeans 15+](https://netbeans.apache.org/download/index.html)
- Java JDK 8 or later
- MySQL Connector/J 8.2.0

## 🚀 Installation & Setup

### Database Configuration
1. Start XAMPP and run Apache & MySQL services
2. Open phpMyAdmin (http://localhost/phpmyadmin)
3. Create a new database named `myproject`
4. Import the SQL file from `Database(MySQL)/myproject.sql`

### MySQL Connector Setup
1. Download [mysql-connector-j-8.2.0.jar](https://dev.mysql.com/downloads/connector/j/)
2. Place the JAR file in:(.../BankManagement\dist\lib\mysql-connector-j-8.2.0.jar) according to your project location.
3. Add the JAR to your project libraries in NetBeans:
- Right-click your project in NetBeans
- Select "Properties" > "Libraries" 
- Click "Add JAR/Folder" and select the connector JAR

### Running the Application
1. Open the project in Apache NetBeans
2. Clean and Build the project (Ctrl+Shift+F11)
3. Run `SourcePakages/bankmanagement/HomePage.java` (Shift+F6)

### 📸 Screenshots

| Login Screen | Dashboard | Account Creation |
|--------------|-----------|------------------|
| ![Login](screenshots/login.png) | ![Dashboard](screenshots/dashboard.png) | ![Create Account](screenshots/create_account.png) |

| Transactions | Customer Details | Statements |
|-------------|------------------|------------|
| ![Transactions](screenshots/transactions.png) | ![Customer](screenshots/customer.png) | ![Statement](screenshots/statement.png) |

### 🏗️ Project Structure
![Project Structure](screenshots/main_ui.png)

### Project Setup
```bash
git clone https://github.com/yourusername/BankManagementSystem.git
cd BankManagementSystem
