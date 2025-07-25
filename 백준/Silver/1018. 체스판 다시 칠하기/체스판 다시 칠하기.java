import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = 64;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'W') {
                    map[i][j] = true; // W 이면 true
                } else {
                    map[i][j] = false; // B 이면 false
                }
            }
        }

        // 8*8 로 잘라서 최소값 구하기
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                find(i,j);
            }
        }

        System.out.println(min);
    }

    static void find(int x, int y) {
        int cnt = 0;

        boolean TF = map[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {

                // 올바른 색이 아니면 cnt 증가
                if (map[i][j] != TF) {
                    cnt++;
                }

                // 다음 칸은 무조건 색이 반대로 바뀐다
                TF = !TF;
            }
            // 한 행이 바뀔 때는 전 행의 마지막 색과 그대로여야 함
            TF = !TF;
        }

        // 첫번째 칸이 반대 색인 경우도 구해야 함
        // 해당 경우의 색칠 할 개수는 64 - cnt
        min = Math.min(min, Math.min(cnt, 64 - cnt));
    }
}