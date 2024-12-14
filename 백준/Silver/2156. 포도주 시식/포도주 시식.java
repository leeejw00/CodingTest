import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] drinks = new int[n+1];
        int[] dp = new int[n+1]; // dp[] : i까지의 가능한 최대 포도주 양

        for(int i = 1; i <= n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = drinks[1];
        for(int i = 2; i <= n; i++) {
            if(i == 2)
                dp[i] = drinks[i-1] + drinks[i];
            else
                dp[i] = Math.max(Math.max(dp[i-2], dp[i-3] + drinks[i-1]) + drinks[i], dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}