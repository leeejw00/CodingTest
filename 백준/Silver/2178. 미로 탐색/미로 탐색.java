import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0'; 
			}
		}
		visited = new boolean[N][M];
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}

	static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row, col});
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			int r = v[0];
			int c = v[1];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=M || map[nr][nc]==0 || visited[nr][nc])
					continue;
				
				q.add(new int[] {nr, nc});
				map[nr][nc] = map[r][c] + 1;
				visited[nr][nc] = true;
				
			}
		}	
	}
}