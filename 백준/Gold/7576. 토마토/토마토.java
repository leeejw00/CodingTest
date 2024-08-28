import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int M, N;
    static Queue<int []> q;
    static int[] dr = {0, 0, 1, -1}; // 동서남북
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 처음에 익은 토마토 큐에 삽입
                if(map[i][j] == 1) q.offer(new int[] {i, j});
            }
        }

        bfs();

        int ans = 0;
        out : for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    ans = -1;
                    break out;
                }

                ans = Math.max(map[i][j] - 1, ans);
            }
        }

        System.out.println(ans);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 경계가 아니고 익지 않은 토마토인 경우 큐에 삽입, 날짜 + 1
                if(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
                    q.offer(new int[] {nr, nc});
                    map[nr][nc] = map[r][c] + 1;
                }
            }
        }
    }
}