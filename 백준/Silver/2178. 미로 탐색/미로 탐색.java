import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String nums = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = nums.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col, 1}); // {row, col, distance}
        visited[row][col] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if (r == N-1 && c == M-1) {
                return dist; // 도착점에 도달했을 때 거리 반환
            }

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, dist + 1});
            }
        }
        return -1; // 도달할 수 없는 경우
    }
}