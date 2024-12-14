import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        int max = arr[1];

        for(int i = 2; i < n+1; i++) {
            if(dp[i-1] < 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i-1] + arr[i];
            }

            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}