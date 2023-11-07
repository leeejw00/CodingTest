import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		parent = new int[N+1];
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1);
		
		for(int i=2; i<parent.length; i++) {
			System.out.println(parent[i]);
		}
		
	}

	static void dfs(int idx) {
		for(int i=0; i<graph[idx].size(); i++) {
			int num = graph[idx].get(i);
			
			if(visited[num]) continue;
			
			visited[num] = true;
			parent[num] = idx;
			dfs(num);
		}
	}
}