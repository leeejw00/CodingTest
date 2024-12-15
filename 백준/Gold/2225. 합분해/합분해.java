import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int div = 1000000000;

        long[][] dp = new long[N+1][K+1];

        for(int i = 1; i <= K; i++) {
            dp[1][i] = i;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % div;
            }
        }

        System.out.println(dp[N][K] % div);
    }
}