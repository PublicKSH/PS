WITH ranked AS (
    SELECT ID, ROW_NUMBER() OVER(ORDER BY SIZE_OF_COLONY DESC) AS RNK, COUNT(*) OVER() AS TOTAL
    FROM ECOLI_DATA
)

SELECT ID, 
    CASE
        WHEN RNK <= TOTAL*0.25 THEN "CRITICAL"
        WHEN RNK <= TOTAL*0.50 THEN "HIGH"
        WHEN RNK <= TOTAL*0.75 THEN "MEDIUM"
        ELSE "LOW"
    END AS COLONY_NAME
FROM ranked
ORDER BY ID