insert into `users` values ('martins', '{bcrypt}$2a$10$vo6g5rGJlLXfyaaDDbYrOO5iUPEl053FePDiNSNh6MnkPSyE2fWOa', 1);
insert into `users` values ('araujo', '{bcrypt}$2a$10$vo6g5rGJlLXfyaaDDbYrOO5iUPEl053FePDiNSNh6MnkPSyE2fWOa', 1);
insert into `users` values ('batista', '{bcrypt}$2a$10$vo6g5rGJlLXfyaaDDbYrOO5iUPEl053FePDiNSNh6MnkPSyE2fWOa', 1);
insert into `users` values ('fernandes', '{bcrypt}$2a$10$vo6g5rGJlLXfyaaDDbYrOO5iUPEl053FePDiNSNh6MnkPSyE2fWOa', 1);

insert into `authorities` values ('martins', 'ROLE_EMPLOYEE');
insert into `authorities` values ('araujo', 'ROLE_MANAGER');
insert into `authorities` values ('batista', 'ROLE_ADMIN');
insert into `authorities` values ('fernandes', 'ROLE_TRAINEE');