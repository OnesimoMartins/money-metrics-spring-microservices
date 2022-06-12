set session_replication_role='replica';
delete from account;
delete from saving;
delete from income;
delete from expense;

alter sequence saving_id_seq restart  with 1;
alter sequence account_id_seq restart  with 1;
alter sequence income_id_seq restart  with 1;
alter sequence expense_id_seq restart with 1;

set session_replication_role='origin';

insert into account(first_name,last_name,username,password,gender) values
('Tania' ,'azevedo','Tania@23','123','FEMALE'),('Katila' ,'pedro','Katila@23','123','FEMALE'),
('Natércia',' soares','soares@23','123','FEMALE'),('Adriano',' polo','Polo@23','123','MALE')
,('João','Cancelo','joao@23','123','MALE'),('Rafael', 'Menezes','Olga@23','123','MALE');

insert into saving(amount,currency_code,account_id,name) values 
(17000,'AOA',1,'poupança para o carro'),(27000,'AOA',1,'poupança para o loja')
,(5000,'AOA',2,'ferias'),(97000,'AOA',3,'aputaro'),(6000,'USD',5,'aputaro');

insert into income(amount,saving_id) values(100,1),(200,2),(500,1),(150,3),(2000,4)
,(3200,4);

insert into income(amount,saving_id,date) values(100,1,'2022-01-14'),
(200,2,'2022-02-14'),(500,1,'2022-01-16'),(150,3,'2022-01-16'),(2000,4,'2022-03-24')
,(3200,4,'2022-03-24'),(250,5,'2022-03-24'),(200,5,'2022-05-04'),(500,5,'2022-03-26');

insert into expense(amount,saving_id) values(400,1),(100,2),(200,1),(50,3),(200,4)
,(400,4);

