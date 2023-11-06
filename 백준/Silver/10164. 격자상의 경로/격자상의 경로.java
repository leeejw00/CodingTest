import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 1}; //우 하
	static int[] dc = {1, 0}; 
	static int road;
	static int ans;
	static int a,b;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		a = 0;
		b = 0;
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j-1] = (M * i) + j; 
				if((M * i) + j == K) {
					a = i; 
					b = j-1;
				}	
			}
		}
		
//		int num = 1;
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				map[i][j] = num;
//				if(num == K) {
//					a = i;
//					b = j;
//				}
//				num++;
//			}
//		}
		
		visited = new boolean[N][M];
		ans = 0;
		road = (N - 1) + (M - 1);
		visited[0][0] = true;
		dfs(0,0,0);
		
		System.out.println(ans);
	}

	static void dfs(int r, int c, int cnt) {
		if(cnt == road) {
			if(K == 0) ans ++;
			else {
				if(visited[a][b])
					ans++;
			}
		}
		
		for(int d=0; d<2; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if(visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1);
			visited[nr][nc] = false;
		}
	}
	
}