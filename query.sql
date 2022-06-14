-- 查询某个小区的房价 
-- select * from t_price_info
-- where price_type = 4
-- and name like '托乐嘉旺邻居%'
-- order by name, execute_date;

-- 查询某个板块的房价 
-- select * from t_price_info
-- where price_type = 3
-- and name like '将军大道%'
-- -- and name like '宁海路%'
-- order by name, execute_date;


-- 查询某个区的房价
-- select * from t_price_info
-- where price_type = 2
-- and name like '雨花%'
-- order by name, execute_date;


SELECT * FROM t_price_info
WHERE
price_type = 2
and pid = ?
        AND execute_date = (SELECT 
            MAX(i.execute_date)
        FROM
            t_price_info i
        WHERE
            i.price_type = 2)

