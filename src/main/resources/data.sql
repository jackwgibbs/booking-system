delete from appointment;
delete from USERS;
delete from STAFF;
insert into USERS (user_id, forename, surname, email, password) VALUES (1, 'Test1', 'Test2', 'e@e.com', 'password');
insert into STAFF (staff_id, forename, surname) VALUES (1, 'Test1', 'Test2');