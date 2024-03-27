# DROP TABLE IF EXISTS Department;
#
# DROP TABLE IF EXISTS Employee;
# DROP TABLE IF EXISTS Position;
# DROP TABLE IF EXISTS Role;
# DROP TABLE IF EXISTS Employee_Roles;
DROP DATABASE IF EXISTS capstone_test;
CREATE DATABASE capstone_test;
USE capstone_test;
CREATE TABLE IF NOT EXISTS Position
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Employee
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    email         VARCHAR(255),
    first_name    VARCHAR(255),
    gender        VARCHAR(10),
    last_name     VARCHAR(255),
    password      VARCHAR(255),
    salary        DECIMAL(10, 2),
    department_id BIGINT,
    position_id   BIGINT,
    online BOOLEAN

);

CREATE TABLE IF NOT EXISTS Department
(
    id          BIGINT PRIMARY KEY,
    description VARCHAR(255),
    name        VARCHAR(255),
    manager_id  BIGINT
);
CREATE TABLE IF NOT EXISTS Role
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Employee_Role
(
    employee_id BIGINT,
    role_id     BIGINT,
    PRIMARY KEY (employee_id, role_id),
    FOREIGN KEY (employee_id) REFERENCES Employee (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES Role (id) ON DELETE CASCADE
);

-- Add the foreign key constraint for Department after Employee table creation
ALTER TABLE Department
    ADD CONSTRAINT FOREIGN KEY (manager_id) REFERENCES Employee (id) ON DELETE CASCADE;
#     ADD CONSTRAINT fk_manager_id


-- Add the foreign key constraint for Employee after Department table creation
ALTER TABLE Employee
    ADD CONSTRAINT FOREIGN KEY (department_id) REFERENCES Department (id) ON DELETE CASCADE;

#     ADD CONSTRAINT fk_department_id

-- Create Position table


-- Create Employee table

-- Create Role table


-- Create join table for Employee and Role (assuming many-to-many relationship)

