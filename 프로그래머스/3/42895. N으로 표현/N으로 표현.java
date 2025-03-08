import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 숫자 1개 ~ 8개까지 사용했을 때 만들어 질 수 있는 모든 경우의 수 담을 자료구조
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // 1개 사용했을 때는 N 본인의 경우만 있음
        dp.get(1).add(N);
        if (number == N) return 1;

        // 2개 ~ 8개 사용한 경우 dp리스트에 넣어주기
        for (int i = 2; i <= 8; i++) {
            // 현재 담을 통 가져오기
            Set<Integer> currSet = dp.get(i);

            // 현재 통 이전 통들의 경우들 사칙연산한 경우
            for (int j = 1; j < i; j++) {
                Set<Integer> preSet = dp.get(j);
                Set<Integer> postSet = dp.get(i - j);

                // 두 통에 있는 모든 경우들 사칙연산한 값 현재 통에 넣어주기
                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        currSet.add(preNum + postNum);
                        currSet.add(preNum - postNum);
                        currSet.add(preNum * postNum);

                        if (preNum != 0 && postNum != 0) {
                            currSet.add(preNum / postNum);
                        }
                    }
                }
            }

            // N을 i만큼 이어붙인 경우도 넣어주기
            currSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        // 다 만들어진 dp리스트 돌면서 number가 된 경우의 idx가 최소값
        for (int i = 2; i <= 8; i++) {
            Set<Integer> curr = dp.get(i);

            for (int num : curr) {
                if (num == number) {
                    return i;
                }
            }
        }

        return -1;
    }
}