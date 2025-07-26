SELECT d.DEPT_ID, d.DEPT_NAME_EN, ROUND(AVG(SAL),0) AS AVG_SAL
FROM HR_DEPARTMENT d
JOIN HR_EMPLOYEES e
ON d.DEPT_ID = e.DEPT_ID
GROUP BY DEPT_ID	
ORDER BY AVG_SAL DESC


/*
부서별 평균 연봉을 조회
부서별로 부서 ID, 영문 부서명, 평균 연봉을 조회
평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 AVG_SAL
부서별 평균 연봉을 기준으로 내림차순
round(연봉,0)

1. 부서id 기준 조인
2. 부서별 그룹화, select에서 평균 구하기avg() , round()
*/