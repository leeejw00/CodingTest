import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int loopy;
		
		public Node(int r, int c, int loopy) {
			this.r = r;
			this.c = c;
			this.loopy = loopy;
		}

		@Override
		public int compareTo(Node o) {
			return this.loopy - o.loopy;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[][] dist;
	static int INF = Integer.MAX_VALUE;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0 ,-1, 1};
	
	public static void main(String[] args) throws IOException {
		int idx = 1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j]= INF;
				}
			}
			
			//시작 지점 dist 입력
			dist[0][0] = map[0][0];
			dijkstra(0,0);
			
			System.out.print("Problem "+idx+": ");
			System.out.println(dist[N-1][N-1]);
			idx++;
		}
	}

	static void dijkstra(int i, int j) {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(i, j, map[i][j]));
		visited[i][j] = true;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int r = curr.r;
			int c = curr.c;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(visited[nr][nc]) continue;
				
				if(dist[nr][nc] > dist[r][c] + map[nr][nc]) {
					dist[nr][nc] = dist[r][c] + map[nr][nc];
					pq.add(new Node(nr, nc, dist[nr][nc]));
					visited[nr][nc] = true;
				}
			}
		}
	}
	
}