import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 찾으려는 값의 (마지막 인덱스 + 1) - (첫번쨰 인덱스) = 중복된 수의 개수
            int ans = (findLastIndex(target) - findStartIndex(target));
            sb.append(ans).append(" ");
        }

        System.out.println(sb);
    }

    static int findStartIndex(int target) {
        int left = 0;
        int right = cards.length; // 개수 구하기 위해서 + 1 해줘야 하기에 -1 하지 않음

        while (left < right) {
            int mid = (left + right) / 2;

            if(target <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int findLastIndex(int target) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if(target < cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}