import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        int cnt = 0; // 이동 횟수

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // target이 첫 번째로 올 때까지 반복
            while(list.getFirst() != target) {
                
                // 2번, 3번 비교 후 최소연산하는 쪽으로 원소 이동
                if(list.indexOf(target) <= (list.size() / 2)){
                   list.addLast(list.removeFirst());
                } else {
                    list.addFirst(list.removeLast());
                }
                
                cnt++;
            }

            // target이 첫 번째 원소인 경우 삭제해주기
            list.removeFirst();
        }

        System.out.println(cnt);
    }
}