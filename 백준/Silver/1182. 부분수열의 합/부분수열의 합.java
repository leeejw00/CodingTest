import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans;
    static int[] nums;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        subset(0);
        System.out.println(S==0? ans-1: ans);
    }

    private static void subset(int cnt) { // cnt : 현재까지 처리한 원소개수
        if(cnt == N) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(!isSelected[i]) continue;
                sum += nums[i];
            }
            if(sum == S) ans++;
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }
}