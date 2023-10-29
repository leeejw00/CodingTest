import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int[] sel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[N];
		sel = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		perm(0);	
	}

	static void perm(int sidx) {
		if(sidx == N) {
			
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				
				visited[i] = true;
				sel[sidx] = arr[i];
				perm(sidx+1);
				visited[i] = false;
			}
		}
	}
}