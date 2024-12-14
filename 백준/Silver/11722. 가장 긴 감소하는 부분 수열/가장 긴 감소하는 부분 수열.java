import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1]; // index i의 원소를 포함하는 감소부분수열 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(arr[i] < arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for(int length : dp) {
            max = Math.max(max, length);
        }

        System.out.println(max);
    }
}