import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, X;
	static List<Node>[] graph;
	static List<Node>[] graphback;
	static int INF = Integer.MAX_VALUE;
	static int[] distGo;
	static int[] distGoback;

	static class Node implements Comparable<Node> {
		public int v;
		public int time;

		public Node(int v, int time) {
			this.v = v;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 마을 수
		int M = Integer.parseInt(st.nextToken()); // 도로 수
		X = Integer.parseInt(st.nextToken()); // 파티 마을 위치

		graph = new ArrayList[N + 1];
		graphback = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			graphback[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, time));
			graphback[b].add(new Node(a, time));
		}

		distGo = new int[N+1];
		distGoback = new int[N+1];
		for(int i=0; i<=N; i++) {
			distGo[i] = INF;
			distGoback[i] = INF;
		}
		
		dijkstra(graph, distGo, X);
		dijkstra(graphback, distGoback, X);

		int sum = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			sum = distGo[i] + distGoback[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

	static void dijkstra(List<Node>[] list, int[] dist, int start) {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int now = curr.v;
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for (Node next : list[now]) {
				if (visited[next.v]) continue;

				if (dist[next.v] > dist[now] + next.time) {
					dist[next.v] = dist[now] + next.time;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

}