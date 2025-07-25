import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Queue<int []> q = new LinkedList<>(); // {중요도값, target인지 아닌지 (1,0)}
            int[] importance = new int[10]; // 중요도 카운트 (1~9)

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int target = Integer.parseInt(st.nextToken()); 

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken()); // 중요도값
                importance[num]++;

                // target이면 1 아니면 0
                int isTarget = 0;
                if (i == target) isTarget = 1;

                // 큐에 문서 넣어주기
                q.offer(new int[] {num, isTarget});
            }

            // 문서 중요도에 맞추어 출력
            int cnt = 0; 
            int importNum = 9;
            while (!q.isEmpty()) {
                // 현재 가장 높은 중요도 수 구하기
                for (int i = 9; i > 0; i--) {
                    if (importance[i] > 0) {
                        importNum = i;
                        break;
                    }
                }

                // 중요도와 지금 꺼낼 큐의 값이 같으면 꺼내고, 아니면 뒤로 보내기
                int[] curr = q.poll();
                int num = curr[0];
                int isTarget = curr[1];

                // 현재 중요도 문서 아니라면 뒤로 보내기
                if (num != importNum) {
                    q.offer(new int[] {num, isTarget});
                }

                // 현재 중요도라면 꺼내고, 타겟이라면 break
                else {
                    cnt++;
                    importance[importNum]--;

                    if (isTarget == 1) {
                        break;
                    }
                }
            }

            System.out.println(cnt);
        } // tc
    }
}