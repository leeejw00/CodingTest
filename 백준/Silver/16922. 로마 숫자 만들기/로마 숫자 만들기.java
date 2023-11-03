import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] arr = {1, 5, 10, 50};
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[(50 * 20) + 1];
		
		cnt = 0;
		dfs(0,0,0);
		System.out.println(cnt);
	}

	static void dfs(int idx, int sum, int depth) {
		if(depth == n) {
			if(!visited[sum]) {
				cnt++;
				visited[sum] = true;
			}
			return;
		}
		
		for(int i=idx; i<4; i++) {
			dfs(i, sum + arr[i], depth+1);
		}
	}
}