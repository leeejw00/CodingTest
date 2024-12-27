import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, V, A, B;
	static int[][] adjArr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점 개수
		M = Integer.parseInt(st.nextToken()); //간선 개수
		V = Integer.parseInt(st.nextToken()); //탐색 시작할 정점 번호
		
		//인접행렬
		adjArr = new int[N+1][N+1];
		//방문체크
		visited = new boolean[N+1];
		
		//간선 정보 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()); //시작정점
			B = Integer.parseInt(st.nextToken()); //끝정점
			
			adjArr[A][B] = adjArr[B][A] = 1;
		}
		dfs(V);
		
		System.out.println();
		visited = new boolean[N+1]; //방문체크 초기화
		
		bfs(V);
		
	}

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		
		for(int i=1; i<N+1; i++) {
			if(adjArr[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
		
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp+" ");
			for(int i=1; i<N+1; i++) {
				if(adjArr[temp][i] ==1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
}