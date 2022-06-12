create type GENDER as enum ('MALE','FEMALE');

create table account(
 id serial,
 username varchar(25) not null unique,
 password varchar(15) not null,
 first_name varchar(100) not null,
 last_name varchar(100) not null,
 gender GENDER not null,
 primary key(id));

create table saving(
id serial,
name varchar(100) not null
,amount decimal(12,2) default 0
,currency_code varchar(5) not null
,account_id int not null references account(id)
,primary key(id));
				   
create table expense(
	id serial,
	saving_id int not null references saving(id),
	amount decimal(12,2) not null,
	description varchar(200) null,
	date timestamp default  CURRENT_TIMESTAMP
);

create table income(
	id serial,
	saving_id int not null references saving(id),
	amount decimal(12,2) not null,
	description varchar(200) null,
	date timestamp default  CURRENT_TIMESTAMP
);
