SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = '2022' AND MONTH(APNT_YMD) = '05'
GROUP BY MCDP_CD
ORDER BY COUNT(*), MCDP_CD


/*
2022년 5월에 예약한 환자 수(COUNT)를 진료과코드(MCDP_CD) 별로 조회
-> 예약취소여부 확인 (APNT_CNCL_YN가 N인 경우만)

컬럼명은 '진료과 코드', '5월예약건수'로 지정
진료과별 예약한 환자 수를 기준으로 오름차순, 진료과 코드를 기준으로 오름차순 
*/