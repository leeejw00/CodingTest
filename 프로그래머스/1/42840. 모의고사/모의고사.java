import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] aAns = new int[answers.length];
        int[] bAns = new int[answers.length];
        int[] cAns = new int[answers.length];

        for(int i = 0; i < answers.length; i++) {
            aAns[i] = a[i % 5];
            bAns[i] = b[i % 8];
            cAns[i] = c[i % 10];
        }

        int aCnt = 0, bCnt = 0, cCnt = 0;
        int max = -1;
        for(int i = 0; i < answers.length; i++) {
            if(aAns[i] == answers[i]) aCnt++;
            if(bAns[i] == answers[i]) bCnt++;
            if(cAns[i] == answers[i]) cCnt++;
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