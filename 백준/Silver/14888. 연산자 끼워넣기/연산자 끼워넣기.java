import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int[] op; //연산자 배열 (+, - , *, /)
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];
         for(int i=0; i<4; i++){
             op[i] = Integer.parseInt(st.nextToken());
         }

         dfs(nums[0],1);

        System.out.println(max);
        System.out.println(min);
    }

    //연산자 개수만큼 완전탐색하여 모든 경우의 수 탐색
    private static void dfs(int num, int idx) {
        if(idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0; i<4; i++){
            if(op[i] > 0){
                op[i]--; //해당 연산자 사용했으니 감소

                if(i == 0)
                    dfs(num + nums[idx], idx+1);
                else if(i == 1)
                    dfs(num - nums[idx], idx+1);
                else if(i == 2)
                    dfs(num * nums[idx], idx+1);
                else
                    dfs(num / nums[idx], idx+1);

                op[i]++; //재귀 끝나고 나오면 연산자 개수 복구
            }
        }
    }
}