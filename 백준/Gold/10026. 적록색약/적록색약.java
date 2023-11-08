import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map;
	static char[][] map2; //적록색약map
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt1, cnt2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		map2 = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String rgb = br.readLine();
			for(int j=0; j<N; j++) {
				 char color = rgb.charAt(j);
				 map[i][j] = color;
				if(color == 'R')
					color = 'G';
				map2[i][j] = color;
			}
		}

		cnt1 = cnt2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					dfs(i,j, map, visited);
					cnt1++;
				}
				if(!visited2[i][j]) {
					visited2[i][j] = true;
					dfs(i,j, map2, visited2);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}

	static void dfs(int r, int c, char[][] maps, boolean[][] visit) {
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			if(visit[nr][nc]) continue;
			if(maps[nr][nc] != maps[r][c]) continue;
			
			visit[nr][nc] = true;
			dfs(nr, nc, maps, visit);
		}
	}
}