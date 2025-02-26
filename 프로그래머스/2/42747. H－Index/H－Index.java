import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);

        int answer = 0;

        // [0 1 3 5 6]
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // h번 이상 인용된 논문 개수

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}