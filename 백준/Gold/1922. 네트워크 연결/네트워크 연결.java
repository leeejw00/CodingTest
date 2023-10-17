import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] p;
	static int[][] graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		p = new int[N+1];
		graph = new int[M+1][3];
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken()); //시작 정점
			graph[i][1] = Integer.parseInt(st.nextToken()); //끝 정점
			graph[i][2] = Integer.parseInt(st.nextToken()); //비용
		}
		
		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		int pick = 0; //간선 뽑은 개수
		int ans = 0; //총 최소 비용
		for(int i=1; i<=M; i++) {
			int x = graph[i][0];
			int y = graph[i][1];
			
			if(findset(x) != findset(y)) {
				union(x, y);
				pick++;
				ans += graph[i][2];
			}
			if(pick==N-1) break;
		}
		System.out.println(ans);
	}

	static void union(int x, int y) {
		p[findset(y)] = p[findset(x)];
	}

	static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}