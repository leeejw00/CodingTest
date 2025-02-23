import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최소힙, 최대힙 두개 생성
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        String command = "";
        int num = 0;
        
        StringTokenizer st;
        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);

            command = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            // 삽입 명령어면 두 힙에 모두 삽입
            if (command.equals("I")) {
                minPq.add(num);
                maxPq.add(num);
            } else if (command.equals("D") && !minPq.isEmpty()) { // 삭제 명령어면 해딩 힙에 맞춰 삭제
                if (num == 1) {
                    int value = maxPq.poll();
                    minPq.remove(value);
                } 
                else if (num == -1) {
                    int value = minPq.poll();
                    maxPq.remove(value);
                }
            }
        }
        
        int[] answer = new int[2];
        if (!minPq.isEmpty()) {
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        
        return answer;
    }
}