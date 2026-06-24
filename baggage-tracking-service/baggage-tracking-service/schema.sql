-- ============================================================
--  Baggage Tracking Service — MySQL Schema
--  Airport Management System | Milestone 3
-- ============================================================

CREATE DATABASE IF NOT EXISTS baggage_db;
USE baggage_db;

CREATE TABLE IF NOT EXISTS baggage (
    baggage_id   INT          PRIMARY KEY AUTO_INCREMENT,
    passenger_id INT          NOT NULL,
    tag_number   VARCHAR(20)  NOT NULL UNIQUE,
    weight       DOUBLE       NOT NULL,
    location     VARCHAR(100) DEFAULT 'Check-in Counter',
    status       VARCHAR(50)  DEFAULT 'Checked In'
);

-- ============================================================
--  Sample Data
-- ============================================================
INSERT INTO baggage (passenger_id, tag_number, weight, location, status)
VALUES
    (1, 'BG1001', 23.5, 'Check-in Counter', 'Checked In'),
    (1, 'BG1002', 10.0, 'Security Area',    'In Security'),
    (2, 'BG1003', 18.2, 'Loading Area',     'Loaded');
