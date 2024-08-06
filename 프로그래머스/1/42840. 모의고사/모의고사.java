import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int aCnt = 0, bCnt = 0, cCnt = 0;
        int max = -1;
        for(int i = 0; i < answers.length; i++) {
            if(a[i % 5] == answers[i]) aCnt++;
            if(b[i % 8] == answers[i]) bCnt++;
            if(c[i % 10] == answers[i]) cCnt++;
        }

        max = Math.max(aCnt, bCnt);
        max = Math.max(max, cCnt);

        List<Integer> list = new ArrayList<>();
        if (aCnt == max) list.add(1);
        if (bCnt == max) list.add(2);
        if (cCnt == max) list.add(3);

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}