import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S;
	static int[] arr;
	static boolean[] sel;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sel = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		powerset(0);
		
		int ans = cnt;
		if(S==0) {
			ans = cnt - 1;
		}
		System.out.println(ans);
	}

	static void powerset(int idx) {
		if(idx == N) {
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				if(sel[i]) {
					sum += arr[i];
				}
			}
			if(sum == S) cnt++;
			return;
		}

		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
	}
}