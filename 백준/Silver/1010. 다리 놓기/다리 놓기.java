import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[30][30];
			
			for(int i=0; i<30; i++) {
				dp[i][i] = 1;
				dp[i][0] = 1;
			}
			
			for(int i=2; i<30; i++) {
				for(int j=1; j<30; j++) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			System.out.println(dp[n][r]);
		}
	}
}