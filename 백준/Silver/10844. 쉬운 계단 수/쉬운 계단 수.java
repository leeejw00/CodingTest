import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long mod = 1000000000;

        long[][] dp = new long[n+1][10]; // dp[자릿수][시작하는수]
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1; // 한자리 수일 때의 초기값
        }

        for(int i = 2; i < n+1; i++) {
            // 0으로 시작할 때
            dp[i][0] = dp[i-1][1] % mod;

            // 9로 시작할 때
            dp[i][9] = dp[i-1][8] % mod;

            // 1~8로 시작할 때
            for(int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long sum = 0;
        for(int i = 1; i < 10; i++) { // 0으로 시작하는 수는 제외
            sum += dp[n][i];
        }

        System.out.println(sum % mod);
    }
}