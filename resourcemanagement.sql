CREATE DATABASE airport_management;

USE airport_management;

CREATE TABLE resources (
    resource_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    resource_name VARCHAR(100),
    resource_type VARCHAR(50),
    availability VARCHAR(20),
    assigned_flight INT
);