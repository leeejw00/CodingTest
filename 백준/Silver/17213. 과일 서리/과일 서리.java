import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[11][31];
		
		for(int i=1; i<=m; i++) {
			dp[1][i] = 1;
			dp[2][i] = i-1;
		}
		
		for(int i=3; i<=n; i++) {
			for(int j=i; j<=m; j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
			}
		}
		
		System.out.println(dp[n][m]);
	}
}