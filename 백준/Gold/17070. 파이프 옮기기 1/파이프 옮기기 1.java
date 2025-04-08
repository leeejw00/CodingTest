import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(1, 2, 1); // 시작좌표 (1,2) (파이프 끝쪽 좌표)

        System.out.println(ans);
    }

    static void dfs(int r, int c, int pipe) { // 시작좌표, 파이프 방향 (가로:1, 세로:2, 대각선:3)
        // 만약, 현재 좌표가 도착지점이라면 ans++ 해주고 return
        if (r == N && c == N) {
            ans++;
            return;
        }

        // 현재 좌표에서 이동 가능한 경우 탐색
        if (pipe == 1) { // 가로인 경우
            if (c+1 <= N && map[r][c+1] == 0) {
                dfs(r, c+1, 1);
            }
        }
        else if (pipe == 2) { // 세로인 경우
            if (r+1 <= N && map[r+1][c] == 0) {
                dfs(r+1, c, 2);
            }
        }
        else if (pipe == 3) { // 대각선인 경우
            if (c+1 <= N && map[r][c+1] == 0) {
                dfs(r, c+1, 1);
            }

            if (r+1 <= N && map[r+1][c] == 0) {
                dfs(r+1, c, 2);
            }
        }

        // 모든 경우에서 대각선 방향 탐색
        if (c+1 <= N && r+1 <= N && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0) {
            dfs(r+1, c+1, 3);
        }
    }
}