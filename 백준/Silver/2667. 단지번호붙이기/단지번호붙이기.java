import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};//상하좌우
	static int[] dc = {0, 0, -1, 1};//상하좌우
	static int cnt; //단지 수
	static int house; //단지 내 집의 수
	static List<Integer> list; //단지 별 집의 수 저장
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		list = new ArrayList<Integer>();
		
		cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]==1 && !visited[r][c]) {
					visited[r][c] = true;
					house = 1; //시작하는 집 1부터 세주기
					bfs(r,c);
					cnt++; //단지 수 증가
					list.add(house);
				}
			}
		}
		Collections.sort(list);//오름차순 정렬
		System.out.println(cnt);
		for(int h : list) {
			System.out.println(h);
		}
		
	}

	static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row,col});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<0 || nc<0 || nc>=N || nr>=N) continue;
				if(visited[nr][nc] || map[nr][nc]!=1) continue;
				
				visited[nr][nc] = true;
				house++;
				q.offer(new int[] {nr,nc});
			}
		}
	}
}