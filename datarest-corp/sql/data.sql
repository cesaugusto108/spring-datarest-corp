insert into `hr_employee` values (1, 1,  'martins', '$2a$10$z26X6WML/cSDUOczqeAc1OJkq3/XEpfAp07UxqvKnFveXJ0Bi3Qba');
insert into `hr_employee` values (2, 1, 'araujo', '$2a$10$z26X6WML/cSDUOczqeAc1OJkq3/XEpfAp07UxqvKnFveXJ0Bi3Qba');
insert into `hr_employee` values (3, 1, 'batista', '$2a$10$z26X6WML/cSDUOczqeAc1OJkq3/XEpfAp07UxqvKnFveXJ0Bi3Qba');
insert into `hr_employee` values (4, 1, 'fernandes', '$2a$10$z26X6WML/cSDUOczqeAc1OJkq3/XEpfAp07UxqvKnFveXJ0Bi3Qba');

insert into `authority` values (1, 'ROLE_EMPLOYEE');
insert into `authority` values (2, 'ROLE_MANAGER');
insert into `authority` values (3, 'ROLE_ADMIN');
insert into `authority` values (4, 'ROLE_TRAINEE');

insert into `hr_employees_authorities` values (1, 1);
insert into `hr_employees_authorities` values (2, 2);
insert into `hr_employees_authorities` values (3, 3);
insert into `hr_employees_authorities` values (4, 4);
