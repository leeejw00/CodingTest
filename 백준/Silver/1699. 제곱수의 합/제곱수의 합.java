import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; // 해당 idx 제곱수 합 최소개수

        dp[1] = 1;

        cycle : for(int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for(int j = 1; j <= i/2; j++) {
                int sum = 0;
                if(i == j*j) { // 현재 항이 어떤 수의 제곱수라면
                    dp[i] = 1;
                    continue cycle;
                } else {
                    sum = dp[j] + dp[i-j];
                    min = Math.min(min, sum);
                }
            }

            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}