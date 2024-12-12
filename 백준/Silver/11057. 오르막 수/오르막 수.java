import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][11]; //dp[수의길이][시작하는수] : 오르막수의 개수 저장
        // 10열에는 0~9까지의 합 저장

        // 한자리 수 일때 초기값과 합
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        dp[1][10] = 10;

        for(int i = 2; i < N+1; i++) {
            long sum = 0;
            for(int j = 0; j < 11; j++) {
                if(j == 0)
                    dp[i][j] = dp[i-1][10] % 10007; // i의 0으로 시작하는 수는 i-1의 오르막개수의 합
                else if(j == 10)
                    dp[i][j] = sum % 10007;
                else
                    dp[i][j] = (dp[i][j-1] - dp[i-1][j-1]) % 10007;

                //만약 범위가 초과되 음수가 나오면
                if (dp[i][j] < 0) {
                    dp[i][j] += 10007; // 음수를 방지하기 위해 10007을 더해줌
                }

                sum += dp[i][j];
            }
        }

        System.out.println(dp[N][10]);
    }
}