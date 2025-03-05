import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬된 상태에서 앞뒤 번호 학생에게만 빌려주도록 처리
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int get = 0; // 체육복 빌려 받은 학생 수

        // 여벌 체육복을 가진 학생이 도난당한 경우를 먼저 처리
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    lost[i] = -1; // 도난당했지만 본인 여벌 체육복으로 처리
                    get++;
                }
            }
        }

        // 남에게 체육복 빌려주기
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) continue;

            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    reserve[j] = -1; // 체육복 빌려준 상태로 변경
                    get++;
                    break;
                }
            }
        }

        int answer = n - lost.length + get;
        return answer;
    }
}