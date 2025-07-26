SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, "%Y-%m") BETWEEN '2022-08' AND '2022-10'
    AND CAR_ID IN (SELECT CAR_ID
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE DATE_FORMAT(START_DATE, "%Y-%m") BETWEEN '2022-08' AND '2022-10'
                    GROUP BY CAR_ID
                    HAVING COUNT(CAR_ID) >= 5)
GROUP BY CAR_ID, MONTH(START_DATE)
HAVING RECORDS >= 1
ORDER BY MONTH, CAR_ID DESC

/*
대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 
총 대여 횟수가 5회 이상인 자동차들에 대해서 (count(car_id) >= 5)
-> 서브쿼리 생성 -> 해당 날짜안에 5회 이상 빌린 자동차 ID 찾기 위해서!!

해당 기간 동안의 월별(group by) 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력
월을 기준으로 오름차순 정렬, 자동차 ID를 기준으로 내림차순
특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외
*/

-- 서브쿼리 먼저 생성
/*SELECT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, "%Y-%m") BETWEEN '2022-08' AND '2022-10'
GROUP BY CAR_ID
HAVING COUNT(CAR_ID) >= 5*/