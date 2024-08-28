import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken()); // 로봇청소기가 바라보는 방향

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(row, col, dir);

        System.out.println(cnt);
    }

    private static void dfs(int r, int c, int dir) {
        // 청소하지 않은 칸이라면 청소
        if(map[r][c] == 0) {
            map[r][c] = 2;
            cnt++;
        }

        // 반시계 방향으로 주변 4칸 탐색
        for(int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; 
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // 청소되지 않은 빈 칸이 있는 경우 전진
            if(nr < N && nc < M && nr >= 0 && nc >= 0 && map[nr][nc] == 0) {
                dfs(nr, nc, dir);
                return;
            }
        }

        // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        int back = (dir + 2) % 4;
        int nr = r + dr[back];
        int nc = c + dc[back];

        // 후진이 가능한 경우 후진
        if(nr < N && nc < M && nr >= 0 && nc >= 0 && map[nr][nc] != 1) {
            dfs(nr, nc, dir); // 후진이므로 바라보는 방향은 변화 x (방향 유지)
        }
    }
}