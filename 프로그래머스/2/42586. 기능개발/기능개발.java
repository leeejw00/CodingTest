import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 답안을 저장할 리스트 선언
        List<Integer> list = new ArrayList<>();

        // 남은 작업 일수를 계산하여 큐에 저장
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                q.add((100 - progresses[i]) / speeds[i]);
            } else { // 나누어 떨어지지 않는다면 하루 더 추가해야 작업 완료됨
                q.add(((100 - progresses[i]) / speeds[i]) + 1);
            }
        }

        int cnt = 1; // 하루 작업 완료량 (하루 배포량)

        // 큐에 있는 첫번째 수 꺼내서 같이 작업 끝낼 수 있는 다음 수들 비교
        int first = q.poll();
        while (!q.isEmpty()) {
            if (q.peek() <= first) { // 다음 작업이 이미 완료된 상태이니 같이 배포
                q.poll();
                cnt++;
            } else { // 다음 작업 미완료라면 하루배포량 리스트에 저장 후 카운트 초기화
                list.add(cnt);
                cnt = 1;
                first = q.poll();
            }
        }
        list.add(cnt); // 마지막날 배포량 저장

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}