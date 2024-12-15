import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n+1];

            if(n <= 3) {
                System.out.println(1);
                continue;
            }

            for(int i = 1; i <= 3; i++) {
                dp[i] = 1;
            }

            for(int i = 4; i <= n; i++) {
                dp[i] = dp[i-3] + dp[i-2];
            }

            System.out.println(dp[n]);
        }
    }
}