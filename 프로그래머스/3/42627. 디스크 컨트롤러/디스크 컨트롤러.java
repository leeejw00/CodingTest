import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업 배열 '요청 시간' 기준 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 우선순위큐를 '소요 시간'오름차순으로 정렬되도록 커스터마이징
        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int idx = 0;
        int time = 0;
        int cnt = 0; // 작업 완료 카운트
        int sum = 0; // 반환 시간 총합

        while (cnt < jobs.length) {
            // 현재 작업중인 소요시간 안에 요청되는 작업이 있다면 큐에 넣어주기
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }

            // 큐에 작업이 없다면 작업 요청시간이 가장 빠른 다음 작업 추가
            if (pq.isEmpty()) {
                time = jobs[idx][0];
            }

            // 큐에 작업이 있다면
            else {
                // 작업
                int[] work = pq.poll();
                time += work[1];
                sum += (time - work[0]);
                cnt++;
            }
        }

        return sum / jobs.length;
    }
}