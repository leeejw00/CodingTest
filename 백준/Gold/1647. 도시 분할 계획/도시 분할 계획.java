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
	static int[][] graph;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		graph = new int[M][3];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]- o2[2];
			}
		});
		
		int pick = 0;
		int sum = 0;
		int idx = 0;
		for(int i=0; i<M; i++) {
			int x = graph[i][0];
			int y = graph[i][1];
			
			if(findset(x) != findset(y)) {
				union(x,y);
				pick++;
				sum += graph[i][2];
			}
			if(pick == N-1) {
				idx = i;
				break; 	
			}
		}
		
		sum -= graph[idx][2];
		System.out.println(sum);
		
	}

	static void union(int x, int y) {
		x = findset(x);
		y = findset(y);
		if(x < y) {
			p[y] = x;
		}else {
			p[x] = y;
		}
	}

	static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}