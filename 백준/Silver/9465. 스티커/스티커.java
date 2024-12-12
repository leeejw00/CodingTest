import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] cost = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j < N+1; j++) {
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];

            for(int i = 2; i < N+1; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + cost[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + cost[1][i];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}