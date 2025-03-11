class Solution {
    public int solution(int[] money) {
        // 각 집에 왔을 때 얻을 수 있는 돈의 최댓값 저장할 dp배열
        // 첫 집 턴 경우, 안 턴 경우 나눠서 계산
        int n = money.length;
        int[] dpFirstVisit = new int[n];
        int[] dpFirstNotVisit = new int[n];

        // dp배열 초기화
        dpFirstVisit[0] = money[0];
        dpFirstVisit[1] = money[0];
        dpFirstNotVisit[1] = money[1];

        // 점화식으로 dp 구현 (현재 집 터는 경우와 털지 않는 경우 중 큰 값)
        for (int i = 2; i < n; i++) {
            dpFirstVisit[i] = Math.max(money[i] + dpFirstVisit[i-2], dpFirstVisit[i-1]);
            dpFirstNotVisit[i] = Math.max(money[i] + dpFirstNotVisit[i-2], dpFirstNotVisit[i-1]);
        }
        
        return  Math.max(dpFirstVisit[n-2], dpFirstNotVisit[n-1]);
    }
}