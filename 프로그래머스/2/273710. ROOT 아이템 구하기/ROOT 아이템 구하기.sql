-- 코드를 작성해주세요
SELECT ITEM_INFO.ITEM_ID, ITEM_INFO.ITEM_NAME
FROM ITEM_INFO 
JOIN ITEM_TREE
ON ITEM_TREE.ITEM_ID = ITEM_INFO.ITEM_ID
WHERE ITEM_TREE.PARENT_ITEM_ID is null
ORDER BY ITEM_INFO.ITEM_ID;
