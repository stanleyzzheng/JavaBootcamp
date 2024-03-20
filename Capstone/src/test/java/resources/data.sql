INSERT INTO EMPLOYEE(id, email, first_name, gender, last_name, password, salary, department_id, position_id)
VALUES (1, 'test123', 'first1', 'male', 'last1', '$2a$10$xo6AnqfV11dUH5CcNLqv1uNmD.dbs0cPXlJfQNBm5QaKD1uIoKMyy', 12345,
        '1', '1');
INSERT
INTO DEPARTMENT(id, description, name, manager_id)
VALUES (1, 'IT Department', 'IT', 1);
INSERT INTO POSITION(id, name)
VALUES (1, 'Software Engineer');
INSERT INTO ROLE(id, name)
VALUES(1, 'ROLE_EMPLOYEE');