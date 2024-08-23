import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 우선순위큐 내림차순 (양수, 음수 따로 저장)
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위큐에 책 번호 삽입
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num > 0) {
                positive.offer(num);
            } else {
                negative.offer(Math.abs(num));
            }
        }

        // 가장 먼 곳의 책 거리 저장해두기
        int max = 0;
        if(positive.isEmpty()) {
            max = negative.peek();
        } else if(negative.isEmpty()) {
            max = positive.peek();
        } else {
            max = Math.max(positive.peek(), negative.peek());
        }

        // 큐가 빌 때까지 이동거리 계산
        int sum = 0;
        while(!positive.isEmpty()) {
            int curr = positive.poll();
            for(int i = 0; i < M-1; i++) {
                positive.poll();
            }
            sum += (curr * 2);
        }

        while(!negative.isEmpty()) {
            int curr = negative.poll();
            for(int i = 0; i < M-1; i++) {
                negative.poll();
            }
            sum += (curr * 2);
        }

        // 가장 먼 곳은 (마지막에 감) 0으로 되돌아오지 않으므로 한번 빼주기
        sum -= max;

        System.out.println(sum);
    }
}