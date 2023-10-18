import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int v; // 정점
		int cost; // 가중치

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
	static List<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, w));
			graph[b].add(new Node(a, w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visited[] = new boolean[N+1];
		
		pq.add(new Node(1,0));
		
		int pick = 0;
		int sum = 0;
		int max = 0;
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.v]) continue;
			
			visited[curr.v] = true;
			sum += curr.cost;
			max = Math.max(max, curr.cost);
			pick++;
			
			if(pick == N) {
				break;
			}
			
			//현재 정점에 연결된 노드들 우선순위큐에 삽입
			for(Node next : graph[curr.v]) {
				if(!visited[next.v])
					pq.add(next);
			}
		}
		sum -= max;
		System.out.println(sum);
		
	}
}