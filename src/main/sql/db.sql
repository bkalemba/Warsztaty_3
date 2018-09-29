-- recreate DB
DROP DATABASE warsztat3;
CREATE DATABASE warsztat3
    CHARACTER SET utf8 COLLATE utf8_general_ci;
USE warsztat3;

-- tables
CREATE TABLE customer(
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE employee(
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  address VARCHAR(255),
  phone VARCHAR(25),
  note VARCHAR(255),
  hour_cost DOUBLE(5,2)
);

CREATE TABLE status(
  id INT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(255)
);

CREATE TABLE vehicle(
  id INT AUTO_INCREMENT PRIMARY KEY,
  brand VARCHAR(255),
  model VARCHAR(255),
  year INT UNSIGNED,
  license_plate VARCHAR(15),
  next_review DATETIME,
  customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customer(id)
    ON DELETE CASCADE
);

CREATE TABLE orders(
  id INT AUTO_INCREMENT PRIMARY KEY,
  vehicle_id INT,
  employee_id INT,
  status_id INT,
  created DATETIME,
  expected_start DATETIME,
  actual_start DATETIME,
  customer_description VARCHAR(255),
  employee_description VARCHAR(255),
  final_cost DOUBLE(9,2),
  parts_cost DOUBLE(9,2),
  work_hours DOUBLE(9,2),
  FOREIGN KEY(vehicle_id) REFERENCES vehicle(id),
  FOREIGN KEY(employee_id) REFERENCES employee(id),
  FOREIGN KEY(status_id) REFERENCES status(id)
);