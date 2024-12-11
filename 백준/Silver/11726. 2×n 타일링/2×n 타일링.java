import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001]; // 수마다 직사각형 채우는 방법의 수 저장

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])  % 10007;
        }

        System.out.println(dp[n]);
    }
}
// 계속 숫자를 더하고 마지막 출력시에만 mod연산을 해줄 경우
// Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에
// 잘못된 값이 출력될 수 있다.