SELECT f.FLAVOR
FROM FIRST_HALF f
JOIN JULY j
ON f.FLAVOR = j.FLAVOR
GROUP BY f.FLAVOR
ORDER BY SUM(f.TOTAL_ORDER) + SUM(j.TOTAL_ORDER) DESC
LIMIT 3




/*
7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 
큰 순서대로 상위 3개의 맛을 조회 - LIMIT

1. 맛 기준 조인
3. 더한 값 기준 내림차순 정렬
4. 상위 3개의 맛 조회
*/