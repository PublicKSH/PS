-- 코드를 작성해주세요
SELECT E.ID , IFNULL(CHILD_COUNT, 0) AS CHILD_COUNT
FROM ECOLI_DATA E
LEFT OUTER JOIN (
SELECT PARENT_ID AS ID, COUNT(*) AS CHILD_COUNT
FROM ECOLI_DATA 
WHERE PARENT_ID IS NOT NULL
GROUP BY PARENT_ID) C
USING(ID)