# SELECT WRITER_ID, SUM(PRICE) AS SUM_PRICE
# FROM USED_GOODS_BOARD
# WHERE STATUS = 'DONE'
# GROUP BY WRITER_ID
# HAVING SUM(PRICE) >= 700000 -> 서브쿼리

SELECT u.USER_ID, u.NICKNAME ,SUM(b.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_USER u
ON b.WRITER_ID = u.USER_ID
WHERE STATUS = 'DONE'
GROUP BY u.USER_ID
HAVING SUM(PRICE) >= 700000
ORDER BY TOTAL_SALES

/*
1. 완료된 금액의 합이 70만 이상인 사람들의 아이디 서브쿼리로 추출
2. 조인한 테이블 이용해서 
*/

/*
완료된(status=done) 중고 거래의 총금액이 70만 원 이상인 사람의 
회원 ID, 닉네임, 총거래금액을 조회
총거래금액을 기준으로 오름차순

user_id 그룹화
조건 : status=done의 금액 >= 70만

1. writer_id = user_id로 조인
2. 조건 = status = done 
3. 회원별 그룹화, -> sum(price) >= 70만
*/