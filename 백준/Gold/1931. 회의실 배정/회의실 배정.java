import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2]; // 시작 시간, 끝나는 시간

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i][0] = start;
            arr[i][1] = end;
        }

        // 끝나는 시간 기준 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            else {
                return o1[1] - o2[1];
            }
        });

        // 회의 선택
        int cnt = 1; // 첫 번째 회의 선택
        int end = arr[0][1]; // 현재 회의 끝나는 시간

        for (int i = 1; i < N; i++) {
            // 해당 회의의 시작 시간이 end보다 크거나 같으면 선택
            if (arr[i][0] >= end) {
                cnt++;
                end = arr[i][1];
            }
        }

        System.out.println(cnt);
    }
}