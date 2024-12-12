import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][2]; // dp[N][시작하는수(0,1)]

        dp[1][0] = dp[1][1] = 1;

        for(int i = 2; i < N+1; i++) {
            for(int j = 0; j < 2; j++) {
                dp[i][0] += dp[i-1][j];
            }
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][1]);
    }
}