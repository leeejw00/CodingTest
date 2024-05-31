import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = move_cnt(N);
        sb.append(cnt + "\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    static int move_cnt(int n) {
        if(n == 1) return 1;
        return 2 * move_cnt(n-1) + 1;
    }

    static void hanoi(int n, int start, int temp, int end) {
        if (n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        // 1. 위의 N-1개 원판 임시기둥 이동
        hanoi(n-1, start, end, temp);
        // 2. 시작기둥 N번 원판 한개를 목적기둥 이동
        sb.append(start + " " + end + "\n");
        // 3. 임시기둥 N-1개 원판 목적기둥 이동
        hanoi(n-1, temp, start, end);
    }
}