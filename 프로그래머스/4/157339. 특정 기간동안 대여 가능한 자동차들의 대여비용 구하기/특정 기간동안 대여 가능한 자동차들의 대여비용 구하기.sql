SELECT c.CAR_ID, c.CAR_TYPE, ROUND(c.DAILY_FEE*(100-p.DISCOUNT_RATE)*30/100)  AS FEE
FROM CAR_RENTAL_COMPANY_CAR c
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY h ON c.CAR_ID = h.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p ON c.CAR_TYPE = p.CAR_TYPE
WHERE c.CAR_ID NOT IN (SELECT CAR_ID
                   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                   WHERE END_DATE > '2022-11-01' AND START_DATE < '2022-12-01')
    AND p.DURATION_TYPE = '30일 이상'
GROUP BY c.CAR_ID
HAVING (c.CAR_TYPE = '세단' OR c.CAR_TYPE = 'SUV') 
    AND (FEE >= 500000 AND FEE < 2000000)
ORDER BY FEE DESC, c.CAR_TYPE, c.CAR_ID DESC

/*
자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 -> where
2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고, -> 2022-11이 없으면 된다 <>
=> 이것을 통해서 대여 가능한 자동차 id -> car_type 얻기

30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 

1. 첫 두 테이블은 car_id로 조인 -> 해당 날짜에 대여 가능한지 확인 위해
     => 이것을 통해서 대여 가능한 자동차 id -> car_type 얻기
2. 할인 테이블에서 해당 car_type에 해당하는 30일 할인율 얼만지 추출 후 계산한 값 select


자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE - 정수부분만) 출력

대여 금액을 기준으로 내림차순 
자동차 종류를 기준으로 오름차순
자동차 ID를 기준으로 내림차순

*/