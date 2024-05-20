create table if not exists tasks(
id bigserial primary key,
description text NOT NULL,
status varchar(125) NOT NULL,
created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
--drop table tasks;

insert into tasks(description, status, created_date) values('buy bread', 'IN_PROGRESS','2024-05-04 10:37:22'),
('make new scheme', 'IN_PROGRESS','2024-05-05 10:15:22'), ('validate code', 'COMPLETED','2024-05-04 10:44:22'),
('review solution', 'NEW','2024-05-04 10:55:22');