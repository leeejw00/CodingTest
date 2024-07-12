import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 내 문서 위치

            LinkedList<int[]> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                queue.offer(new int[] {i, Integer.parseInt(st.nextToken()) }); // { 초기 위치, 중요도 }
            }

            int print = 0; // 인쇄 횟수
            while(!queue.isEmpty()) {

                int[] front = queue.poll(); // 첫 원소 뽑기
                boolean isMax = true; // 첫 원소가 가장 큰 원소인지 판단하는 변수

                // 큐에 남아있는 원소들과 중요도 비교
                for(int i = 0; i < queue.size(); i++) {
                    // 처음 뽑은 원소보다 큐에 있는 i번쨰 원소가 중요도가 더 클 경우
                    if(front[1] < queue.get(i)[1]) {

                        // 뽑은 원소 및 i 이전의 원소들을 뒤로 보내기
                        queue.offer(front);
                        for(int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        // front 원소가 가장 큰 원소가 아니었으므로 false를 하고 탐색 마침
                        isMax = false;
                        break;
                    }
                }
                // front 원소가 가장 큰 원소가 아니었으므로 다음 반복문으로 넘어감
                if(!isMax) continue;

                // front 원소가 가장 큰 원소였으므로 해당 원소 출력 (위 if문에 모두 걸리지 않았다면 가장 큰 원소인 것)
                print++;

                if(front[0] == M) break; // 이 때, 출력한 원소가 찾고자 하는 문서인지 확인 후 맞다면 종료
            }

            System.out.println(print);
        }
    }
}