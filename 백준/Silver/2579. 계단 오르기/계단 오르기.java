import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = score[1];

        for(int i = 2; i <= n; i++) {
            if(i == 2) {
                dp[i] = score[i-1] + score[i];
            } else {
                dp[i] = Math.max(dp[i-2], dp[i-3] + score[i-1]) + score[i];

            }
        }

        System.out.println(dp[n]);
    }
}