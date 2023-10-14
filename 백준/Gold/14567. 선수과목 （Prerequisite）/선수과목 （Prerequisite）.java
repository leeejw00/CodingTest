import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] degree = new int[N+1];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			degree[end]++;
		}
		
		int[] sem = new int[N+1]; //과목마다 듣는 학기 저장
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		//진입차수 0인 것 큐에 넣기
		for(int i=1; i<degree.length; i++) {
			if(degree[i]==0) {
				q.offer(i);
				sem[i] = 1;
			}	
		}
		
		while(!q.isEmpty()) {
			int num = q.poll();

			ArrayList<Integer> curr = graph.get(num);
			
			for(int i=0; i<curr.size(); i++) {
				degree[curr.get(i)]--; //진입차수 감소
				
				if(degree[curr.get(i)]==0) { //진입차수0되면 큐에 삽입, 이전학기+1 저장
					q.offer(curr.get(i));
					sem[curr.get(i)] = sem[num]+1;
				}	
			}	
		}
		
		for(int i=1; i<sem.length; i++) {
			System.out.print(sem[i]+" ");
		}
		
	}
}