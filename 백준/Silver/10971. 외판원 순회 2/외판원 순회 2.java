import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; //도시 수
	static int[][] W; //비용행렬
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
	
		W = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		
        
		for(int i=0; i<N; i++) {
			dfs(i, i, 0, 0);
		}
		
		System.out.println(ans);
	}

	//(출발지점, 현재지점, 비용, 방문도시개수)
	static void dfs(int start, int curr, int cost, int visitCnt) {
		visited[start] = true; 
		
        //마지막 도시 도착했을 때 출발 지점 갈수 있는지 확인
		if(visitCnt == N-1) { 
			if(W[curr][start]!=0) {
				cost += W[curr][start];
				ans = Math.min(ans, cost);
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i] && W[curr][i]!=0) { 
				visited[i] = true;
				dfs(start, i, cost+W[curr][i], visitCnt+1);
				visited[i] = false;
			}
		}
	}
	
	
	
}