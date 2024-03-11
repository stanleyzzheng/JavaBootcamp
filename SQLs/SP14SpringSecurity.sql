select * from student_course;
select * from student;
CREATE DATABASE testdb;
DROP DATABASE testdb;
SELECt * FROM note_seq;
DROP TABLE IF EXISTS NOTE;
CREATE DATABASE notes_db;
SELECT * FROM notes;
SELECT * FROM users;
SELECT * FROM authorities;
SELECT * FROM NOTE;
CREATE DATABASE mydatabase;
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');

INSERT INTO users_roles(user_id,role_id) VALUES (1,1);
DELETE FROM USER WHERE id = 2;
DELETE FROM users_roles WHERE user_id =1;
UPDATE ROLE SET name = 'ROLE_ADMIN' WHERE id = 1;
UPDATE users_roles SET role_id = 2 WHERE user_id=1;

DROP DATABASE mydatabase;

SELECT * FROM role;
SELECT * FROM user;
SELECT * FROM users_roles;
