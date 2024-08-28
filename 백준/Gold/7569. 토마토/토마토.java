import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    static int[][][] map;
    static Queue<int []> q;
    static int[] dx = {0, 0, -1, 1, 0, 0}; // 상 하 좌 우 윗상자 아랫상자
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        q = new LinkedList<>();
        map = new int[H][N][M]; // 높이 세로 가로
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    // 익은 토마토 큐에 삽입 (시작 정점들 삽입)
                    if(map[i][j][k] == 1) q.offer(new int[] {i, j, k});
                }
            }
        }

        bfs();

        int ans = 0;
        out : for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0) {
                        ans = -1;
                        break out;
                    }

                    ans = Math.max(map[i][j][k] - 1, ans); // 며칠 지나는지기 때문에 -1
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int z = curr[0]; // 높이
            int y = curr[1]; // 세로
            int x = curr[2]; // 가로

            // 인접한 토마토 탐색 (6방향)
            for(int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int ny = y + dy[d];
                int nx = x + dx[d];

                // 경계가 아니고 익지 않은 토마토가 있는 경우
                if(nz < H && nz >= 0 && ny < N && ny >= 0 && nx < M && nx >= 0
                        && map[nz][ny][nx] == 0) {
                    q.offer(new int[] {nz, ny, nx});
                    map[nz][ny][nx] = map[z][y][x] + 1;
                }
            }
        }
    }
}