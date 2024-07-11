import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] S, B; // 신맛, 쓴맛 배열
    static boolean[] isSelected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        S = new int[N];
        B = new int[N];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);
        System.out.println(min);
    }

    private static void subset(int cnt) { // cnt : 현재까지 고려한 원소개수
        if(cnt == N) {
            int mulS = 1;
            int sumB = 0;
            int notSelCnt = 0;
            for(int i = 0; i < N; i++) {
                if(!isSelected[i]) {
                    notSelCnt++;
                    continue;
                }
                mulS *= S[i];
                sumB += B[i];
            }
            if(notSelCnt != N) {
                min = Math.min(min, Math.abs(mulS-sumB));
            }
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }
}