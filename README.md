# RTO Management System

A console-based Java application that digitises the day-to-day operations of a **Regional Transport Office (RTO)**. It supports vehicle registration, secure login, fine management, vehicle search, and detail updates for both administrators and registered users.

---

## Table of Contents

1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Project Structure](#project-structure)
4. [Database Schema](#database-schema)
5. [Prerequisites](#prerequisites)
6. [Setup & Installation](#setup--installation)
7. [Compilation & Running](#compilation--running)
8. [Usage Guide](#usage-guide)
9. [Number Plate Format](#number-plate-format)
10. [Password Policy](#password-policy)
11. [License](#license)

---

## Features

| Feature | Admin | User |
|---|:---:|:---:|
| Register a new vehicle | ✅ | ❌ |
| Search vehicle by number plate | ✅ | ❌ |
| Update vehicle details (name, insurance, PUC, contact) | ✅ | ✅ (own vehicle) |
| Add fine to a vehicle | ✅ | ❌ |
| Remove fine from a vehicle | ✅ | ❌ |
| View own vehicle details | ❌ | ✅ |
| Pay outstanding fine | ❌ | ✅ |

---

## Tech Stack

- **Language**: Java (JDK 8+)
- **Database**: MySQL / MariaDB
- **Connectivity**: JDBC (`mysql-connector-j-8.1.0.jar`)
- **Build**: Manual `javac` compilation (no build tool required)

---

## Project Structure

```
RTO/
├── src/
│   ├── RTO.java                  # Entry point — main menu and application flow
│   ├── JDBC_Connection.java      # Opens and returns a MySQL JDBC connection
│   ├── RTO_Registration.java     # Handles new vehicle registration
│   ├── RTO_Login.java            # User login and post-login menu
│   ├── RTO_Fine.java             # Add, remove, and pay fines
│   ├── RTO_Search_vehicle.java   # Search vehicle details by number plate
│   ├── RTO_Update_detail.java    # Update owner name, insurance, PUC, contact
│   └── password_verify.java      # Password creation rules and validation
├── lib/
│   └── mysql-connector-j-8.1.0.jar   # MySQL JDBC driver
└── SQL FILE/
    └── rto_office.sql            # Database schema and seed data
```

---

## Database Schema

The application uses a database named **`rto_office`** with two tables.

### `city`

| Column | Type | Description |
|--------|------|-------------|
| `name` | VARCHAR(20) PK | City name |
| `id`   | INT(20)        | Numeric RTO district code used in number plates |

36 Gujarat cities are pre-populated (Ahmedabad → id 1, Rajkot → id 3, Surat → id 5, etc.).

### `registration`

| Column | Type | Description |
|--------|------|-------------|
| `number_plate` | VARCHAR(50) PK | Unique vehicle number plate (e.g. `GJ 1 AB 1234`) |
| `owner_name`   | VARCHAR(50)    | Name of the vehicle owner |
| `vehicle_name` | VARCHAR(50)    | Vehicle make/model |
| `vehicle_color`| VARCHAR(50)    | Vehicle colour |
| `vehicle_type` | VARCHAR(50)    | Type (car, bike, truck, etc.) |
| `fines`        | DOUBLE         | Cumulative outstanding fine amount |
| `insurance`    | VARCHAR(20)    | Insurance expiry date (DD/MM/YYYY) |
| `puc`          | VARCHAR(20)    | PUC expiry date (DD/MM/YYYY) |
| `password`     | VARCHAR(50)    | User login password |
| `owner_phone_no`| VARCHAR(20)   | Owner contact number |

---

## Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **MySQL or MariaDB** server running locally on port `3306`
- MySQL root user with no password (or update credentials in `JDBC_Connection.java`)

---

## Setup & Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Priyanshu147/RTO.git
cd RTO
```

### 2. Set Up the Database

Open your MySQL client (CLI or phpMyAdmin) and import the provided SQL file:

```bash
mysql -u root -p < "SQL FILE/rto_office.sql"
```

This creates the `rto_office` database with the `city` and `registration` tables and inserts all city seed data.

### 3. Configure Database Credentials (if needed)

If your MySQL setup uses a different username or password, edit `src/JDBC_Connection.java`:

```java
String dbuser = "root";   // ← change to your MySQL username
String dbpass = "";       // ← change to your MySQL password
```

---

## Compilation & Running

From the **project root directory**, compile all Java source files with the JDBC driver on the classpath:

```bash
# Linux / macOS
javac -cp lib/mysql-connector-j-8.1.0.jar -d out src/*.java

# Windows
javac -cp lib\mysql-connector-j-8.1.0.jar -d out src\*.java
```

Then run the application:

```bash
# Linux / macOS
java -cp out:lib/mysql-connector-j-8.1.0.jar RTO

# Windows
java -cp out;lib\mysql-connector-j-8.1.0.jar RTO
```

---

## Usage Guide

On startup you will see the **Main Menu**:

```
----Welcome to RTO app----
1) Login as Administrator
2) Login as User
3) Exit
```

### Administrator Flow

**Default admin password:** `12345678`

After logging in, the admin menu offers:

| Option | Description |
|--------|-------------|
| 1 | Register a new vehicle |
| 2 | Update vehicle details by number plate |
| 3 | Search vehicle by number plate |
| 4 | Add a fine to a vehicle |
| 5 | Remove all fines from a vehicle |
| 6 | Back to main menu |

### User Flow

Users log in with their **number plate** and **password**. After successful authentication, the user can:

| Option | Description |
|--------|-------------|
| 1 | Update own vehicle details |
| 2 | Pay outstanding fine (requires debit/credit card details) |
| 3 | Back to main menu |

---

## Number Plate Format

All plates follow the Gujarat RTO format:

```
GJ <district-id> <XX> <0000>
```

- `GJ` — state code (Gujarat)
- `<district-id>` — numeric code mapped from the `city` table (e.g., `1` for Ahmedabad)
- `<XX>` — two random uppercase letters (auto-generated) or custom input
- `<0000>` — four random digits (auto-generated) or custom input

**Example:** `GJ 1 AB 1234`

---

## Password Policy

Passwords set during vehicle registration must satisfy **all** of the following rules:

- Minimum **8 characters** long
- Contains at least one **uppercase letter** (A–Z)
- Contains at least one **lowercase letter** (a–z)
- Contains at least one **digit** (0–9)
- Contains at least one **special character** from: `# ! @ $ % ^ & *`

---

## License

This project is licensed under the terms of the [LICENSE](LICENSE) file included in this repository.
