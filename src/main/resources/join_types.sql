-- https://ru.wikipedia.org/wiki/Join_(SQL)
-- https://stackoverflow.com/questions/448023/what-is-the-difference-between-left-right-outer-and-inner-joins
-- https://blog.codinghorror.com/a-visual-explanation-of-sql-joins/
-- https://www.w3schools.com/sql/sql_having.asp
-- https://www.codeproject.com/Articles/33052/Visual-Representation-of-SQL-Joins

-- INNER JOIN
SELECT * FROM jdbc_db.person p INNER JOIN jdbc_db.city c ON p.city_id = c.id;
-- or
SELECT * FROM jdbc_db.person p JOIN jdbc_db.city c ON p.city_id = c.id;

-- LEFT OUTER JOIN
SELECT * FROM jdbc_db.person p LEFT OUTER JOIN jdbc_db.city c ON p.city_id = c.id;

-- RIGHT OUTER JOIN
SELECT * FROM jdbc_db.person p RIGHT OUTER JOIN jdbc_db.city c ON p.city_id = c.id;

-- FULL OUTER JOIN - there is no such clause in my SQL, but it could be emulated
SELECT * FROM jdbc_db.person p LEFT OUTER JOIN jdbc_db.city c ON p.city_id = c.id
UNION
SELECT * FROM jdbc_db.person p RIGHT OUTER JOIN jdbc_db.city c ON p.city_id = c.id;

-- CROSS JOIN - it is a INNER JOIN without ON
SELECT * FROM jdbc_db.person p CROSS JOIN jdbc_db.city c ON p.city_id = c.id;
SELECT * FROM jdbc_db.person p, jdbc_db.city c;
