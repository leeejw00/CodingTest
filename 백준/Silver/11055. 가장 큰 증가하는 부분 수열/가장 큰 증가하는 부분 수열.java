import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1]; // index i의 원소를 포함하고, 그 단계까지 증가수열 합의 최댓값

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        for(int i = 2; i <= n; i++) {
            dp[i] = arr[i];
            for(int j = 1; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int max = 0;
        for(int sum : dp) {
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}