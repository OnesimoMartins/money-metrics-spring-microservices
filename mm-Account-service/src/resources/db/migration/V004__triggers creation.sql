create or replace function INSERT_ON_INCOME()
 returns trigger as
$body$
begin
    update saving set amount=
	(select amount from saving where id=new.saving_id)+ new.amount
	where id=new.saving_id;
	   return NEW;
end

$body$
language PLPGSQL;

create or replace trigger INSERT_ON_INCOME_TRIGGER after insert on 
income for each row  execute procedure INSERT_ON_INCOME();



create or replace function INSERT_ON_EXPENSE()
 returns trigger as
$body$
begin
    update saving set amount=
	(select amount from saving where id=new.saving_id)- new.amount
	where id=new.saving_id;
	   return NEW;
end

$body$
language PLPGSQL;

create or replace trigger INSERT_ON_EXPENSE_TRIGGER after insert on 
expense for each row  execute procedure INSERT_ON_EXPENSE();