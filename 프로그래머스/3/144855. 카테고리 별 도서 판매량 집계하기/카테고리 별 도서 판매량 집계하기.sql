SELECT b.CATEGORY, SUM(bs.SALES) AS TOTAL_SALES
FROM BOOK b
JOIN BOOK_SALES bs
ON b.BOOK_ID = bs.BOOK_ID
WHERE YEAR(bs.SALES_DATE) = '2022' AND MONTH(bs.SALES_DATE) = '1'
GROUP BY CATEGORY
ORDER BY CATEGORY


/*
2022년 1월의 카테고리 별 도서 판매량을 합산하고, 
카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
카테고리명을 기준으로 오름차순

1. 두 테이블 ID 기준 조인
2. 카테고리 별 그룹화
3. SELECT에서 SUM(SALES)
4. 정렬
*/