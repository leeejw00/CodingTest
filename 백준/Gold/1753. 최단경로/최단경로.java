import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int v;
		int cost;
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V;
	static List<Node>[] graph;
	static int[] dist; // 시작점에서 idx정점까지 최단 경로 저장
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); //정점 개수
		int E = Integer.parseInt(st.nextToken()); //간선 개수
		int start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 출발
			int v = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			graph[u].add(new Node(v, w));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		Dijkstra(start);
		for(int i=1; i<=V; i++) {
			if(dist[i]==INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	static void Dijkstra(int start) {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int curr = pq.poll().v;
			
			if(visited[curr]) continue;
			
			visited[curr] = true;
			
			for(Node next : graph[curr]) {
				if(dist[next.v] > dist[curr] + next.cost) {
					dist[next.v] = dist[curr] + next.cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}	
}