import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1}; // 동 서 남 북
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 처음 빙산 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true) {
            visited = new boolean[N][M];
            
            int ice = 0;

            // 빙산 조각 세기
            for(int r = 1; r < N - 1; r++) {
                for(int c = 1; c < M - 1; c++) {
                   if(!visited[r][c] && map[r][c] > 0) {
                       countIceBfs(r, c);
                       ice++;
                   }
                }
            }

            // 빙산이 두 덩어리 이상인 경우 (분리된 경우)
            if(ice >= 2) {
                break;
            }

            // 빙산이 다 녹은 경우
            if(ice == 0) {
                year = 0;
                break;
            }

            // 빙산 녹이기
            meltIceBfs();

            year++;
        }

        System.out.println(year);
    }

    private static void meltIceBfs() {
        visited = new boolean[N][M]; // 빙산 있던 자리 체크 위한 배열
        Queue<int []> q = new LinkedList<>();

        // 완전탐색하며 빙산이 있는 칸들은 큐에 삽입
        for(int r = 1; r < N - 1; r++) {
            for(int c = 1; c < M - 1; c++) {
                if(map[r][c] > 0) {
                    q.offer(new int[] {r, c});
                    visited[r][c] = true;
                }
            }
        }

        // 큐에 빙산을 다 넣었으면 큐가 빌 때까지 빙산 녹이기
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            // 주변 바닷물 개수 세기
            int water = 0;
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 빙산이었던 칸이 아니면서 바닷물인 경우
                if(!visited[nr][nc] && map[nr][nc] <= 0) water++;
            }

            map[r][c] -= water;
        }
    }

    private static void countIceBfs(int row, int col) {
        Queue<int []> q = new LinkedList<>();
        visited[row][col] = true;
        q.offer(new int[] {row, col});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
                if(visited[nr][nc] || map[nr][nc] <= 0) continue;

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}