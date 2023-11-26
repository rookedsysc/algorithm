-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM rest_info
WHERE (food_type, favorites) IN (SELECT food_type, max(favorites) FROM rest_info GROUP BY FOOD_TYPE)
ORDER BY food_type desc;