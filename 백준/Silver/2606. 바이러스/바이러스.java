import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static List<Integer>[] adjList;
	static int cnt;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //컴퓨터 수
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //연결쌍 수
		
		adjList = new ArrayList[N+1]; //1~N
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		//인접리스트
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); //시작정점
			int B = Integer.parseInt(st.nextToken()); //끝정점
			
			adjList[A].add(B);
			adjList[B].add(A);
		}
		cnt = 0; //바이러스 걸리게 되는 컴퓨터 수
		dfs(1);
		System.out.println(cnt);
	}

	static void dfs(int v) {
		visited[v] = true;
		
		for(int i=0; i<adjList[v].size(); i++) {
			int next = adjList[v].get(i);
			
			if(!visited[next]) {
				dfs(next);
				cnt++;
			}
		}
	}
}