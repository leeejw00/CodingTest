SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE FAVORITES IN (SELECT MAX(FAVORITES)  
                    FROM REST_INFO
                    GROUP BY FOOD_TYPE)
GROUP BY FOOD_TYPE
ORDER BY FOOD_TYPE DESC

/*
음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
음식 종류를 기준으로 내림차순
*/

/*
1. 음식종류별로 좋아요 가장 많은 식당의 즐겨찾기 수 추출 (서브쿼리)
2. 그것에 포함되는 즐겨찾기를 가진 식당들만 SELECT (WHERE절에 조건으로 넣기)
3. 정렬
*/