import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static class Test implements Comparable<Test>{
		public int idx;
		public int score; 
		
		public Test(int idx, int score) {
			this.idx = idx;
			this.score = score;
		}

		@Override
		public int compareTo(Test o) {
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Test> pq = new PriorityQueue<>();
		for(int i=1; i<=8; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(new Test(i, num));
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=0; i<5; i++) {
			Test t = pq.poll();
			sum += t.score;
			list.add(t.idx);
		}
		
		Collections.sort(list);
		
		System.out.println(sum);
		for(int qNum : list) {
			System.out.print(qNum + " ");
		}
	}
}