import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums; // 1 ~ N
    static int[] arr; // 중복 없이 M개를 고른 수열
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        arr = new int[M];
        isSelected = new boolean[N+1];
        
        seq(0); 
        System.out.println(sb);
    }

    private static void seq(int cnt) { // cnt : 전체수열중 수를 뽑은 횟수
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }

        // 한번 뽑을 때 가능한 상황에 대한 시도 (1 ~ N)
        for(int i = 1; i <= N; i++) {
            if(isSelected[i]) continue;
            arr[cnt] = i;
            isSelected[i] = true;
            seq(cnt+1);
            isSelected[i] = false;
        }
    }
}