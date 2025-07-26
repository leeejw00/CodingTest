SELECT COUNT(*) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
WHERE FISH_TYPE IN (SELECT FISH_TYPE
                    FROM FISH_INFO
                    GROUP BY FISH_TYPE
                    HAVING AVG(IFNULL(LENGTH, 10)) >= 33)
GROUP BY FISH_TYPE
ORDER BY FISH_TYPE


-- 서브쿼리로 평균길이가 33이상인 물고기들의 FISHTYPE 가져오기 -> 전체 쿼리 WEHRE절에 사용
# SELECT FISH_TYPE
# FROM FISH_INFO
# GROUP BY FISH_TYPE
# HAVING AVG(IFNULL(LENGTH, 10)) >= 33


/*
평균 길이가 33cm 이상인 물고기들을 종류별로 분류
잡은 수, 최대 길이, 물고기의 종류를 출력
- 10cm이하의 물고기들은 10cm로 취급하여 평균 길이를 구해주세요. IFNULL(LENGTH,10)

 물고기 종류에 대해 오름차순
*/