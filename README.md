# ✈️ Airport Operations Management System

> A microservices-based enterprise platform for managing day-to-day operations of a busy international airport.

---

## 📖 Overview

The Airport Operations Management System is a comprehensive platform designed to handle the complex operations of a modern international airport. Built using **Microservices Architecture**, the system is split into six focused services that run independently and communicate through REST APIs.

---

## 🏗️ Microservices Architecture

| Service | Primary Users | Key Capability |
|---------|---------------|----------------|
| **Flight Scheduling Service** | Airline Staff, Admins | Schedule & Conflict Management |
| **Passenger Check-in Service** | Passengers, Airline Staff | Check-in & Boarding |
| **Baggage Tracking Service** | Ground Staff | Real-time Bag Tracking |
| **Security Monitoring Service** | Security Personnel | Surveillance & Alerts |
| **Resource Management Service** | Admins, Ground Staff | Staff/Gate/Equipment Management |
| **Notification & Alert Service** | All Users | Real-time Notifications |

---

## 👥 Intended Users

| User Group | Access & Responsibilities |
|------------|---------------------------|
| **Airport Administrators** | Full system access for monitoring, planning, and reporting |
| **Airline Staff** | Scheduling, check-in, passenger manifests, boarding |
| **Security Personnel** | Live feed monitoring, incident response, activity logs |
| **Ground Handling Staff** | Baggage tracking, equipment coordination |
| **Passengers** | Self-service check-in, boarding passes, baggage tracking |

---

## 🛠️ Technology Stack

| Category | Technology |
|----------|------------|
| **Language** | Java |
| **Framework** | Spring Boot |
| **ORM** | Hibernate (JPA) |
| **Database** | MySQL |
| **API Testing** | Postman |
| **Architecture** | RESTful Microservices |

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- MySQL Server
- Maven or Gradle
- Git

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/airport-operations-management-system.git
   cd airport-operations-management-system
   ```

2. **Set up databases**:
   - Create databases: `airport_management`, `checkin_db`, `baggage_db`

3. **Configure database connections**:
   - Update `application.properties` files in each service

4. **Build and run each service**:
   ```bash
   # Example for Flight Scheduling Service
   cd flight-scheduling-service
   mvn spring-boot:run
   ```

5. **Access the services**:
   - Flight Scheduling: `http://localhost:8080/api/flights`
   - Check-in Service: `http://localhost:8081/api/checkin`
   - Resource Management: `http://localhost:9090/api/resources`

---

## 📊 Database Schema

### Flight Scheduling Service
```sql
CREATE TABLE flights (
    flight_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    flight_number VARCHAR(20) NOT NULL,
    departure_city VARCHAR(50),
    arrival_city VARCHAR(50),
    departure_time DATETIME,
    arrival_time DATETIME,
    gate_number VARCHAR(10),
    terminal VARCHAR(20),
    aircraft_type VARCHAR(50),
    operational_status VARCHAR(30)
);
```

### Check-in Service
```sql
CREATE TABLE checkin (
    id BIGINT NOT NULL AUTO_INCREMENT,
    flight_number VARCHAR(255),
    is_boarded BIT NOT NULL,
    passenger_name VARCHAR(255),
    seat_number VARCHAR(255),
    PRIMARY KEY (id)
);
```

### Baggage Tracking Service
```sql
CREATE TABLE baggage (
    baggage_id INT PRIMARY KEY AUTO_INCREMENT,
    passenger_id INT NOT NULL,
    tag_number VARCHAR(20) NOT NULL UNIQUE,
    weight DOUBLE NOT NULL,
    location VARCHAR(100) DEFAULT 'Check-in Counter',
    status VARCHAR(50) DEFAULT 'Checked In'
);
```

### Resource Management Service
```sql
CREATE TABLE resources (
    resource_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    resource_name VARCHAR(100),
    resource_type VARCHAR(50),
    availability VARCHAR(20),
    assigned_flight INT
);
```

---

## 📝 API Endpoints

### Flight Scheduling Service

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/flights` | Retrieve all flights |
| GET | `/api/flights/{id}` | Retrieve flight by ID |
| POST | `/api/flights` | Create a new flight |
| PUT | `/api/flights/{id}` | Update flight details |
| DELETE | `/api/flights/{id}` | Delete a flight |

### Passenger Check-in Service

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/checkin` | Register a new passenger check-in |
| GET | `/api/checkin` | Retrieve all checked-in passengers |
| GET | `/api/checkin/{id}` | Retrieve a passenger by ID |
| PUT | `/api/checkin/{id}` | Update passenger check-in details |
| DELETE | `/api/checkin/{id}` | Delete a passenger check-in record |

### Baggage Tracking Service

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/baggage` | Register new baggage |
| GET | `/api/baggage` | View all baggage records |
| GET | `/api/baggage/{id}` | Track a specific bag |
| PUT | `/api/baggage/{id}` | Update baggage location/status |
| GET | `/api/baggage/passenger/{passengerId}` | Get baggage by passenger |

### Resource Management Service

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/resources` | Add a new resource |
| GET | `/api/resources` | Retrieve all resources |
| GET | `/api/resources/{id}` | Retrieve resource by ID |
| PUT | `/api/resources/{id}` | Update or assign a resource |
| DELETE | `/api/resources/{id}` | Delete a resource |

---

## 📚 References

- [Software Engineering by Ian Sommerville](https://dn790001.ca.archive.org/0/items/bme-vikkonyvek/Software%20Engineering%20-%20lan%20Sommerville.pdf)
- [International Air Transport Association (IATA)](https://www.iata.org/)

---
