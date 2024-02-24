import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1,  1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0,0);

        System.out.println(min);
    }

    private static void dfs(int cnt, int sum) {
        if(cnt == 3) {
            min = Math.min(min, sum);
            return;
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(!visited[i][j] && visitCheck(i,j)){
                    visited[i][j] = true;

                    int sumAdded = checkDir(i, j);
                    dfs(cnt + 1, sum + sumAdded);

                    visitedToFalse(i, j);
                }
            }
        }
    }

    private static boolean visitCheck(int r, int c) {
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(visited[nr][nc])
                return false;
        }
        return true;
    }

    private static int checkDir(int r, int c) {
        int sum = map[r][c];

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!visited[nr][nc]){
                visited[nr][nc] = true;
                sum += map[nr][nc];
            }
        }
        return sum;
    }

    private static void visitedToFalse(int r, int c) {
        visited[r][c] = false;

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            visited[nr][nc] = false;
        }
    }
    
}