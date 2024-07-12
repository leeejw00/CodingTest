import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 우선순위큐를 사용하여 가장 낮은 7개의 점수만 유지
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            double score = Double.parseDouble(br.readLine());
            if (pq.size() < 7) {
                pq.offer(score);
            } else if (score < pq.peek()) {
                pq.poll();
                pq.offer(score);
            }
        }

        List<Double> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.sort(result);

        for (double score : result) {
            bw.write(String.format("%.3f\n", score));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}