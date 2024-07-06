import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1]; // 1 ~ N
        result = new int[M];

        comb(1, 0);
        System.out.println(sb);
    }

    // 조합
    private static void comb(int idx, int cnt) { // idx : nums의 index, cnt : 수를 뽑은 횟수

        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i <= N; i++) {
            result[cnt] = i;
            comb(i+1, cnt+1); // i+1 : 현재 뽑힌 수의 다음부터 시작
        }
    }
}