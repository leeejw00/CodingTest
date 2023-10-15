import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; 
	static boolean[] sel; //조합 뽑기
	static int[] people; //구역 별 인구 수
	static List<Integer>[] graph;
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		people = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken()); 
		}
		
		
		graph = new ArrayList[N];
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int links = Integer.parseInt(st.nextToken()); //각 구역 별 연결된 구역 수
			
			for(int j=0; j<links; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i].add(num-1);
				graph[num-1].add(i);
			}
		}
		
		min = Integer.MAX_VALUE;
		
		//선거구 나누기
		sel = new boolean[N];
		comb(0);
		
		if(min == Integer.MAX_VALUE) { // ->두 선거구 연결된 경우 없다는 것
			System.out.println(-1); 
		}else {
			System.out.println(min);
		}
	}//main
	
	
	static void comb(int idx) {
		if(idx == N) { 
			List<Integer> A = new ArrayList<Integer>(); //뽑은 구역 : A선거구
			List<Integer> B = new ArrayList<Integer>(); //안뽑은 구역 : B선거구
			visited = new boolean[N];
			
			for(int i=0; i<N; i++) {
				if(sel[i]) 
					A.add(i); 
				else
					B.add(i); 
			}
			
			//한 선거구에 모든 구역 있는 경우 불가
			if(A.size()==0 || B.size()==0) {
				return;
			}
			
			//각 선거구 모두 연결되었다면 true 반환
			boolean aLinked = bfs(A);
			boolean bLinked = bfs(B);
			
			//두 선거구 true라면 인구 차이 계산
			if(aLinked && bLinked) {
				calP();
			}
			return;
		}
		
		sel[idx] = true;
		comb(idx+1);
		sel[idx] = false;
		comb(idx+1);
	}

	static boolean bfs(List<Integer> l) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[l.get(0)] = true;
		q.add(l.get(0));
		
		int cnt = 1; //방문한 구역수 (출발지점 포함)
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			//현재 구역과 연결된 구역들 돌면서 확인
			for(int i=0; i<graph[curr].size(); i++) {
				int next = graph[curr].get(i);
				
				//같은 선거구이고 방문하지 않은 곳이라면
				if(l.contains(next) && !visited[next]) { 
					q.add(next);
					visited[next] = true;
					cnt++;
				}
			}
		}
		
		//선거구 안 구역 모두 연결되었다면 true
		if(cnt==l.size())
			return true;
		else
			return false;
	}
	
	//인구 수 차이 계산
	private static void calP() {
		int cntA = 0;
		int cntB = 0;
		
		for(int i=0; i<N; i++) {
			if(sel[i]) 
				cntA += people[i];
			else
				cntB += people[i];
		}
		
		int pNum = Math.abs(cntA-cntB);
		min = Math.min(min, pNum);
	}
}