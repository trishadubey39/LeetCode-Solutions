# Write your MySQL query statement below
SELECT s.user_id, 
ROUND(IFNULL(AVG(c.action = 'confirmed'), 0),2) as confirmation_rate
FROM signups AS s
LEFT JOIN confirmations c ON s.user_id = c.user_id
GROUP BY s.user_id;