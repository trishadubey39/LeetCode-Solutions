# Write your MySQL query statement below
with cte as (
SELECT*,DENSE_RANK() over(PARTITION BY t.Department ORDER BY t.Salary desc)  as "rank" from
(SELECT  d1.name as "Department",e1.name "Employee",e1.salary  as "Salary" from employee e1 join department d1 on e1.`departmentId` = d1.id) t
)
SELECT c.Department,c.Employee ,c.Salary from cte c where c.rank<=3;