SELECT CAR_ID,
        CASE 
            WHEN CAR_ID IN (SELECT CAR_ID
                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                            WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE) THEN '대여중'
            ELSE '대여 가능'
        END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
GROUP BY CAR_ID
ORDER BY CAR_ID DESC



/*
2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 
대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가
하여 자동차 ID와 AVAILABILITY 리스트를 출력

자동차 ID를 기준으로 내림차순 정렬
*/

/*
1. 2022년 10월 16일에 start_end 사이에 있는 car_id 추출 (서브쿼리)
2. 해당 쿼리를 통해 추출한 car_id에 포함되어 있으면 대여중, 아니라면 대여 가능 (case문 사용)
*/