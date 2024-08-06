import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 학생의 답안 패턴
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 학생 별 맞힌 문제 수를 저장할 배열
        int cnt[] = new int[3];
        
        // 답안과 정답 비교
        int max = -1;
        for(int i = 0; i < cnt.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j])
                    cnt[i]++;
            }
        }

        // 최대 맞힌 문제 수
        max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < cnt.length; i++) {
            if(max == cnt[i]) list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}