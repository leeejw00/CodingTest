import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] board;
	static boolean[] visited;
	static int ans = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		visited = new boolean[26]; //알파벳 개수
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
 		dfs(0,0,1);
		System.out.println(ans);
	}

	 static void dfs(int r, int c, int cnt) { 
		 visited[board[r][c] - 'A'] = true;
		 ans = Math.max(ans, cnt);

		 for(int d=0; d<4; d++) {
			 int nr = r + dr[d];
			 int nc = c + dc[d];
			 
			 if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			 if(visited[board[nr][nc] - 'A']) continue;
			 
			 dfs(nr, nc, cnt+1);
			 visited[board[nr][nc] - 'A'] = false;
		 }
	}
}