# Write your MySQL query statement below
with cte as(
  select *
  from Employees
  where manager_id is not null
)
select e.employee_id from 
cte as e left join Employees as e2
on e2.employee_id =e.manager_id 
where e.salary <30000 and e2.employee_id is null
order by e.employee_id 