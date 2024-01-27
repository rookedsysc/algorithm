-- 코드를 입력하세요
SELECT member_id, member_name, gender, DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d') as DATE_OF_BIRTH 
FROM MEMBER_PROFILE 
WHERE GENDER = "W" and MONTH(DATE_OF_BIRTH) = 3 and TLNO is not null
ORDER BY MEMBER_ID ;