import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 현재 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        int[] arr = new int[K];

        long max = 0;

        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        max++; // 최대길이 1 더해주기

        long min = BinaraySearch(arr, max, N);
        System.out.println(min - 1);
    }

    // [upper bound 형식]
    static long BinaraySearch(int[] arr, long max, int N) {
        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            long cnt = 0;

            // 구해진 중간 길이로 잘라서 만들어지는 랜선 개수 세기
            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }

            // 필요한 랜선 개수보다 작다면 최대 길이 줄이기
            if(cnt < N) {
                max = mid;
            } else { // 그렇지 않으면 최소 길이 늘리기
                min = mid + 1;
            }
        }

        return min;
    }
}