INSERT INTO USERS(ID, USERNAME, PASSWORD)
VALUES (1, 'sarah1', '$2a$10$JrzgwHOt1IFU6d5KMVN97uyA3XaT3w7Zw0S6y1Hzlfb7vVP1LNHq.');
INSERT INTO USERS(ID, USERNAME, PASSWORD)
VALUES (2, 'kum', '$2a$10$JrzgwHOt1IFU6d5KMVN97uyA3XaT3w7Zw0S6y1Hzlfb7vVP1LNHq.');
INSERT INTO USERS(ID, USERNAME, PASSWORD)
VALUES (3, 'stan', '$2a$10$1GM/OKn7VpjTwroS1B1G4uhqOob/IG2HK/IURl0usxBH0yCQOZWSy');
--
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY)
VALUES ('sarah1', 'ROLE_NOTE-OWNER'),
       ('stan', 'ROLE_NOTE-OWNER'),
       ('kum', 'ROLE_NON-OWNER');

-- INSERT INTO NOTES(ID, TITLE, DESCRIPTION, OWNER)
-- VALUES (99, 'First Note', 'Hello World!', 'sarah1');
--
-- INSERT INTO NOTES(ID, TITLE, DESCRIPTION, OWNER)
-- VALUES (100, 'Second Note', 'Hello World!', 'sarah1');
--
-- INSERT INTO NOTES(ID, TITLE, DESCRIPTION, OWNER)
-- VALUES (101, 'Third Note', 'Hello World!', 'sarah1');
--
-- INSERT INTO NOTES(ID, TITLE, DESCRIPTION, OWNER)
-- VALUES (102, 'Kumar''s Note', 'Hello Guys!', 'kum');

--  ON DUPLICATE KEY
-- UPDATE TITLE =
-- VALUES (TITLE), DESCRIPTION =
-- VALUES (DESCRIPTION), OWNER =
-- VALUES (OWNER)