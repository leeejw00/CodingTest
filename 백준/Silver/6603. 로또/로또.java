import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            arr = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void comb(int start, int depth) {
        // 만약 6개 다 뽑았으면 sb에 넣어주기
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            result[depth] = arr[i];
            comb(i+1, depth+1);
        }
    }
}