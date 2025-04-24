import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, T;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int robotR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    robotR = i; // 공기청정기 밑부분 r좌표 저장
                }
            }
        }

        while (T-- > 0) {
            spreadDust(); // 미세먼지 확산
            runRobot(); // 공기청정기 작동
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }

        // 공기청정기 -2 된거 빼기 위해 +2
        System.out.println(sum + 2);
    }

    static void spreadDust() {
        // 현재 맵의 5이상의 미세먼지 큐에 넣어주기
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 5)
                    q.offer(new int[] {i, j, map[i][j]});
            }
        }

        // 큐가 빌때까지 큐에 있는 미세먼지 꺼내어 인접4방향 확산
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dust = curr[2];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 경계거나 공기청정기인 경우 넘기기
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (map[nr][nc] == -1) continue;

                // 미세먼지 확산
                map[nr][nc] += dust / 5;
                map[r][c] -= dust / 5;
            }
        }
    }

    static void runRobot() {
        int top = robotR - 1;
        int bottom = robotR;

        // 위쪽 반시계 방향 순환
        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i-1][0];
        }
        for (int i = 0; i < M-1; i++) {
           map[0][i] = map[0][i+1];
        }
        for (int i = 0; i < top; i++) {
            map[i][M-1] = map[i+1][M-1];
        }
        for (int i = M-1; i > 1; i--) {
            map[top][i] = map[top][i-1];
        }
        map[top][1] = 0; // 공기청정기 바로 오른쪽은 항상 0

        // 아래쪽 시계 방향 순환
        for (int i = bottom + 1; i < N-1; i++) {
            map[i][0] = map[i+1][0];
        }
        for (int i = 0; i < M-1; i++) {
            map[N-1][i] = map[N-1][i+1];
        }
        for (int i = N-1; i > bottom; i--) {
            map[i][M-1] = map[i-1][M-1];
        }
        for (int i = M-1; i > 1; i--) {
            map[bottom][i] = map[bottom][i-1];
        }
        map[bottom][1] = 0;
    }
}