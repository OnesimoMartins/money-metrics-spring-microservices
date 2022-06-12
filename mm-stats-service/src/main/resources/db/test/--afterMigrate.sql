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

insert into account(name,last_name) values('Tania' ,'azevedo'),('Katila' ,'pedro'),('Natércia',' soares'),
('Adriano',' polo'),('João','Cancelo'),('Olga', 'de Menezes');

insert into saving(amount,currency_code,account_id,name) values 
(17000,'AOA',1,'poupança para o carro'),(27000,'AOA',1,'poupança para o loja')
,(5000,'AOA',2,'ferias'),(97000,'AOA',3,'aputaro');

