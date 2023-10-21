# Write your MySQL query statement below
with cte as
(select num, (dense_rank() over(order by num)) as num_rank
from mynumbers),

cte2 as (select num, count(num_rank) as rank_count
from cte
group by num_rank,num
having count(num_rank) = 1
order by num desc
limit 1)

select case 
           when count(num) = 1 then num
           when count(num) = 0 then Null
       end as num
 from cte2