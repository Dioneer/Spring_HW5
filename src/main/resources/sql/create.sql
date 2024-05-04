create table if not exists tasks(
id bigserial primary key,
description text NOT NULL,
status varchar(125) NOT NULL,
created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
drop table tasks;