select * from customer;
select customer_id, first_name, last_name, active from customer where active=1;
select customer_id, first_name, last_name from customer where last_name='Smith';

select first_name, last_name from customer order by last_name asc;
select first_name, last_name from customer;

select active FROM customer WHERE first_name = 'LINDA' AND last_name = 'WILLIAMS';