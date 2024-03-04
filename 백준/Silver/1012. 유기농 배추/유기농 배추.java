import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int K;
    static int cnt;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[M][N];
            map = new int[M][N];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            int worm = 0;
            cnt = 0;
            out : for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i,j);
                        worm++;
                    }
                    if(cnt == K) break out;
                }
            }
            System.out.println(worm);
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt++;

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nc >= 0 && nr < M && nc < N) {
                if(!visited[nr][nc] && map[nr][nc] == 1) {
                    dfs(nr, nc);
                }
            }
        }
    }
}