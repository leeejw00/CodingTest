-- 헤비유저들 ID 가져오기 위한 서브쿼리
# SELECT HOST_ID
# FROM PLACES 
# GROUP BY HOST_ID
# HAVING COUNT(*) >= 2


-- 전체 쿼리
SELECT *
FROM PLACES 
WHERE HOST_ID IN (SELECT HOST_ID
                    FROM PLACES 
                    GROUP BY HOST_ID
                    HAVING COUNT(*) >= 2)
ORDER BY ID

/*
공간을 둘 이상 등록한 사람을 "헤비 유저"
헤비 유저가 등록한 공간의 정보 조회
아이디 순 오름차순

*/