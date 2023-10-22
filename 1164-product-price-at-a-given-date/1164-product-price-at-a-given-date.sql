# Write your MySQL query statement below
WITH LatestChange AS (
    SELECT product_id,
           COALESCE(MAX(change_date), '1900-01-01') as latest_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)

, LatestChangePrice AS (
    SELECT lc.product_id, pr.new_price 
    FROM LatestChange lc
    JOIN Products pr ON lc.product_id = pr.product_id AND lc.latest_date = pr.change_date
)

SELECT p.product_id,
       COALESCE(lcP.new_price, 10) as price 
FROM (SELECT DISTINCT product_id FROM Products) p
LEFT JOIN LatestChangePrice lcP ON p.product_id = lcP.product_id
ORDER BY p.product_id;