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

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int idx = coins.length - 1;
        while (K > 0) {
            if (K < coins[idx]) {
                idx--;
                continue;
            }

            cnt += K / coins[idx];
            K %= coins[idx--];
        }

        System.out.println(cnt);
    }
}