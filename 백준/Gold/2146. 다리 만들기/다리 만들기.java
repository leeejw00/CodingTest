import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, min;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1}; // 상하좌우
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 다른 섬인지 구분 위해 dfs로 섬 표시 (숫자로 구분)
        int islandNum = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    changeIslandNum(i, j, islandNum++);
                }
            }
        }

        // 섬 잇는 다리 최단 거리 구하기 (bfs)
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) { // 2이상이 섬
                    bfs(i, j, map[i][j]); // 시작섬 번호 전달
                }
            }
        }

        System.out.println(min);
    }

    static void bfs(int row, int col, int startIsland) {
        visited = new boolean[N][N];
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col, 0}); // 거리 = 0

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = curr[2];

            // 현재 위치가 바다가 아니고 시작섬이 아니라면 (다른 섬에 도달한 경우)
            if (map[r][c] != 0 && map[r][c] != startIsland) {
                min = Math.min(min, dis - 1); // 마지막 섬 거리 빼주기
            }

            // 거리가 최솟값보다 크다면 탐색 x
            if (dis > min) return;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 바다이거나 다른 섬인 경우 이동
                // 경계거나 방문했거나 섬의 테두리가 아닌 경우 continue
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc] || map[nr][nc] == startIsland) continue;

                q.offer(new int[]{nr, nc, dis + 1});
                visited[nr][nc] = true;
            }
        }
    }

    static void changeIslandNum(int r, int c, int islandNum) {
        visited[r][c] = true;
        map[r][c] = islandNum;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if (visited[nr][nc] || map[nr][nc] == 0) continue;

            changeIslandNum(nr, nc, islandNum);
        }
    }
}