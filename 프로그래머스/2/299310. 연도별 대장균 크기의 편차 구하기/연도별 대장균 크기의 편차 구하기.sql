-- 코드를 작성해주세요
WITH year_max AS (
SELECT MAX(SIZE_OF_COLONY) AS MAX_SIZE, YEAR(DIFFERENTIATION_DATE) AS YEAR
FROM ECOLI_DATA
GROUP BY YEAR(DIFFERENTIATION_DATE))

SELECT Y.YEAR, (Y.MAX_SIZE - E.SIZE_OF_COLONY) AS YEAR_DEV, E.ID
FROM year_max Y
JOIN ECOLI_DATA E
ON YEAR(E.DIFFERENTIATION_DATE) = Y.YEAR
ORDER BY Y.YEAR ASC, YEAR_DEV ASC