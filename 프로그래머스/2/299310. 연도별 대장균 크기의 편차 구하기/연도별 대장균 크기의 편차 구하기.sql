SELECT 
    YEAR(a.DIFFERENTIATION_DATE) AS YEAR,
    b.MAX_SIZE - A.SIZE_OF_COLONY AS YEAR_DEV,
    a.ID
FROM ECOLI_DATA AS a
JOIN (
    SELECT 
        YEAR(DIFFERENTIATION_DATE) AS YEAR,
        MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
) AS b
ON YEAR(a.DIFFERENTIATION_DATE) = b.YEAR
ORDER BY
    YEAR, YEAR_DEV


/*
분화된 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID) 를 출력
YEAR_DEV = 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
연도에 대해 오름차순, 대장균 크기의 편차에 대해 오름차순

1. 연도별 최대 균 크기 구한 서브테이블 생성
2. 생성한 테이블과 기존 테이블 연도 기준으로 조인
3. 합쳐진 테이블 이용해서 select 할 때, max - size 로 편차 가져오기
4. 정렬
*/