class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int mod = 1000000007;
        
        // dp[][] : 집에서 학교까지 갈 수 있는 경우의 수의 합
        int[][] dp = new int[n+1][m+1];

        // 물웅덩이 있는 곳 -1로 초기화
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        // 초기값 설정
        dp[1][1] = 1;

        // dp 입력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 물웅덩이 있는 곳이면 넘어가기
                if (dp[i][j] == -1) continue;
                
                // 그렇지 않고 위, 왼쪽 물웅덩이 아니면 값 더해주기
                if (dp[i-1][j] > 0) dp[i][j] += dp[i-1][j] % mod;
                if (dp[i][j-1] > 0) dp[i][j] += dp[i][j-1] % mod;
            }
        }

        // 학교위치값이 경우의 수의 합
        return dp[n][m] % mod;
    }
}