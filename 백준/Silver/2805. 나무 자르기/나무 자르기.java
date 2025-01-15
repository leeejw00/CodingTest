import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        // 이분탐색
        int min = 0;
        int mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            // 현재 잘려진 길이 합 구하기
            long sum = 0;
            for(int i = 0; i < N; i++) {
                if (trees[i] - mid > 0) { // 음수 제외
                    sum += (trees[i] - mid);
                }
            }

            // 현재 잘린 길이의 합 < 목표 길이 -> 톱 높이 낮추기
            if (sum < M) {
                max = mid;
            } else { // 그렇지 않으면 톱 높이 높이기
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}