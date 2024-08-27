import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int rain = 1; rain <= 100; rain++) {
            visited = new boolean[n][n];
            int cnt = 0; // 안전영역 개수

            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    if(!visited[r][c] && map[r][c] > rain) {
                        bfs(r, c, rain);
                        cnt++;
                    }
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    private static void bfs(int row, int col, int rain) {
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

                if(nr >= n || nc >= n || nr < 0 || nc < 0) continue;
                if(visited[nr][nc] || map[nr][nc] <= rain) continue;

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}