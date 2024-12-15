import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int len = num.length();
        int mod = 1000000;

        int[] dp = new int[len+1];

        dp[0] = 1;
        for(int i = 1; i <= len; i++) {
            int cur = num.charAt(i-1) - '0';
            if(cur >= 1 && cur <= 9) { // 한자리 수가 1~9 사이이면 암호
                dp[i] += dp[i-1];
                dp[i] %= mod;
            }

            if(i == 1) continue; // 첫번째 숫자를 보고있는 경우라면 여기까지

            int prev = num.charAt(i-2) - '0';
            if(prev == 0) continue; // 이전 자리 수가 0이면 x

            int twoNums = prev * 10 + cur;

            if(twoNums >= 10 && twoNums <= 26) { // 두자리수가 10 ~ 26 사이이면 암호
                dp[i] += dp[i-2];
                dp[i] %= mod;
            }
        }

        System.out.println(dp[len] % mod);
    }
}