SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF f
JOIN ICECREAM_INFO i
ON f.FLAVOR = i.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER

/*
상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량
총주문량(TOTAL_ORDER) 오름차순

- 맛 기준 조인
- 성분타입 기준 그룹화
- 성분타입별로 주문량 SUM

1. 두 테이블 맛 기준 조인해준다 (FLAVOR, INGREDIENT_TYPE, TOTAL_ORDER)
2. 성분타입 기준으로 그룹화해준다 -> SELECT에서 SUM(TOTAL_ORDER)
*/