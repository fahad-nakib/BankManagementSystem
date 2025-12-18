# Bank Management System
A Java and MySQL based application for managing bank operations with an intuitive graphical interface.

## Features
- **Account Management**: Create, view, update, and delete bank accounts
- **Branch‑Based Access Control**: Employees can only access data from their assigned branch
- **Role-Based Access**: Admin, Manager, Accountant, and User each have distinct permissions
- **Transaction Processing**: Secure handling of deposits, withdrawals, and fund transfers
- **User Authentication**: Login system with credential validation for bank employees
- **Reporting Module**: Generate account statements and transaction history
- **Customer Management**: Maintain complete customer profiles and account details

### Role-Based Login Interface

| Login Screen | User Login | Admin Login |
|--------------|-----------|------------------|
| ![Login](Images/Screenshot_51.png) | ![Login](Images/Screenshot_68.png) | ![Login](Images/Screenshot_52.png) |

### Admin Features
| Admin Feature (showing- Employee info branch-wise) |
|--------------|
| ![Login](Images/Screenshot_53.png) |

| Admin Feature (showing- view all branch information)|
|--------------|
| ![Login](Images/Screenshot_54.png) |

| Admin Feature (showing- all salary type)|
|--------------|
| ![Login](Images/Screenshot_55.png) |

| Admin Feature (showing- view particular branch information)|
|--------------|
| ![Login](Images/Screenshot_56.png) |

| Admin Feature (showing- Loan details)|
|--------------|
| ![Login](Images/Screenshot_57.png) |

| Admin Feature (Employee Registration)|
|--------------|
| ![Login](Images/Screenshot_58.png) |

| Admin Feature (Update Employee)|
|--------------|
| ![Login](Images/Screenshot_59.png) |

| Admin Feature (Management- set salary, add branch, and other criteria)|
|--------------|
| ![Login](Images/Screenshot_60.png) |


### Accountant Features
| Accountant Feature (Update user, Deposit, withdraw )|
|--------------|
| ![Login](Images/Screenshot_61.png) |

| Accountant Feature (Register user)|
|--------------|
| ![Login](Images/Screenshot_62.png) |

### Manager Features
| Manager Feature (Showing- Employee details based on different criteria )|
|--------------|
| ![Login](Images/Screenshot_63.png) |

| Manager Feature (Showing- Update Employee Details)|
|--------------|
| ![Login](Images/Screenshot_65.png) |

| Manager Feature (Showing- Loan Management)|
|--------------|
| ![Login](Images/Screenshot_66.png) |

| Manager Feature (Showing- View user feedback)|
|--------------|
| ![Login](Images/Screenshot_67.png) |

### User Features
| User Feature (Showing- View user profile)|
|--------------|
| ![Login](Images/Screenshot_69.png) |

| User Feature (Showing- Transfer Balance)|
|--------------|
| ![Login](Images/Screenshot_72.png) |

| User Feature (Showing- provide feedback)|
|--------------|
| ![Login](Images/Screenshot_71.png) |


## Prerequisites
- [XAMPP](https://www.apachefriends.org/download.html) (for MySQL database)
- [Apache NetBeans 15+](https://netbeans.apache.org/download/index.html)
- Java JDK 8 or later
- MySQL Connector/J 8.2.0

## Installation & Setup

### Database Configuration
1. Start XAMPP and run Apache & MySQL services
2. Open phpMyAdmin (http://localhost/phpmyadmin)
3. Create a new database named `myproject`
4. Import the SQL file from `Database(MySQL)/myproject.sql`

### MySQL Connector Setup
1. Download [mysql-connector-j-8.2.0.jar](https://dev.mysql.com/downloads/connector/j/)
2. Place the JAR file in:(.../BankManagement\dist\lib\mysql-connector-j-8.2.0.jar) according to your project location. OR follow step 3.
3. Add the JAR to your project libraries in NetBeans:
- Right-click your project in NetBeans
- Select "Properties" > "Libraries" 
- Click "Add JAR/Folder" and select the connector JAR

### Running the Application
1. Open the project in Apache NetBeans
2. Clean and Build the project (Ctrl+Shift+F11)
3. Run `SourcePakages/bankmanagement/HomePage.java` (Shift+F6)


### Project Setup
```bash
git clone https://github.com/yourusername/BankManagementSystem.git
cd BankManagementSystem

