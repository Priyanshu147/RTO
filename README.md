# RTO Management System

The RTO Management System is a comprehensive Java-based application designed to streamline the operations of a Regional Transport Office (RTO). It facilitates vehicle registration, fine management, updates, and searches, catering to both administrators and users.

## Project Overview

This system is composed of several Java files, each dedicated to specific functionalities such as registration, login, fine management, vehicle search, and updates. It leverages MySQL for database management and JDBC for database connectivity.

## Key Features

- **User Registration**: Enables users to register their vehicles by providing essential details like owner name, vehicle specifications, contact information, etc.
- **Login System**: Facilitates secure access for both administrators and users using their unique credentials.
- **Fine Management**: Allows users to pay their vehicle-related fines, while administrators can add or remove fines as per requirements.
- **Vehicle Search**: Provides a feature for users and administrators to retrieve vehicle information using the vehicle number plate.
- **Update Details**: Administrators have the privilege to update vehicle details such as owner name, insurance date, PUC date, and contact information.

## Project Structure

The project is structured into the following Java files:

- `JDBC_Connection.java`: Manages JDBC connection to the MySQL database.
- `password_verify.java`: Handles password creation and validation for user registration.
- `RTO_Fine.java`: Implements functionalities related to fine management.
- `RTO_Login.java`: Manages the login system for both administrators and users.
- `RTO_Registration.java`: Handles vehicle registration functionalities.
- `RTO_Search_vehicle.java`: Implements functionalities for searching vehicle information.
- `RTO_Update_detail.java`: Manages functionalities for updating vehicle details.
- `RTO.java`: The main file that contains the main menu and drives the overall project execution.

## Database Setup

To utilize this system, a MySQL database with the necessary tables needs to be set up. The database schema and setup instructions can be found in the `database_setup.sql` file.

## How to Use

1. **Clone the Repository**: Clone the repository to your local machine.
2. **Database Setup**: Set up the MySQL database with the required tables as specified in the `database_setup.sql` file.
3. **Compile**: Compile all Java files.
4. **Run**: Execute the `RTO.java` file to start the application.
5. **Navigate**: Use the provided menu options to navigate through different functionalities.
