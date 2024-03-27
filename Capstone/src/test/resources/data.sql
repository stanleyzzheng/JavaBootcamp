INSERT
INTO DEPARTMENT(id, description, name, manager_id)
VALUES (1, 'IT Department', 'IT', null);

INSERT INTO `POSITION`(id, name)
VALUES (1, 'Software Engineer');

INSERT INTO EMPLOYEE(id, email, first_name, gender, last_name, password, salary, department_id, position_id, online)
VALUES (1, 'test123@gmail.com', 'first1', 'male', 'last1',
        '$2a$10$Se6HW4Y5oOvPqN2/3u9DLOp0Zy0Kd3ujvnyL67Y9EiDDGIsMzbQ2q', 12345,
        1, 1, true);


INSERT INTO ROLE(id, name)
VALUES (1, 'ROLE_EMPLOYEE');
INSERT INTO ROLE(id, name)
VALUES (2, 'ROLE_MANAGER');

INSERT INTO EMPLOYEE_ROLE(employee_id, role_id)
VALUES (1, 1);

INSERT INTO EMPLOYEE_ROLE(employee_id, role_id)
VALUES (1, 2);

INSERT INTO EMPLOYEE(id, email, first_name, gender, last_name, password, salary, department_id, position_id, online)
VALUES (2, 'test2@gmail.com', 'test2', 'male', 'test2', '$2a$10$Se6HW4Y5oOvPqN2/3u9DLOp0Zy0Kd3ujvnyL67Y9EiDDGIsMzbQ2q',
        1234, 1, 1, false);
