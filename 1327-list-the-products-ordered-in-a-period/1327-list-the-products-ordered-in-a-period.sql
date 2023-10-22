# Write your MySQL query statement below

with cte as(select product_id, sum(unit) as unit
from Orders
where YEAR(order_date)=2020
and MONTH(order_date)=2
group by product_id)

select product_name, unit from Products ,cte
where Products.product_id=cte.product_id
and unit>=100;