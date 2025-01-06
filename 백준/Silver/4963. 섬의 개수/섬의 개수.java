import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h; // 너비, 높이
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1}; // 상 하 좌 우 좌상 우상 좌하 우하
    static int[] dc = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;
            for(int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i,j);
                        island++;
                    }
                }
            }

            System.out.println(island);
        }
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int d = 0; d < 8; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
            if(map[nr][nc] == 0 || visited[nr][nc]) continue;

            dfs(nr, nc);
        }
    }
}