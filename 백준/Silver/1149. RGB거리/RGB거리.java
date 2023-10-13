import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] house = new int[N+1][3]; //[0]:red, [1]: green, [2]: blue 비용
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N+1][3]; //모든 집 칠하는 비용 최소값 구하기
		
		dp[1][0] = house[1][0];
		dp[1][1] = house[1][1];
		dp[1][2] = house[1][2];
		
		for(int i=2; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
		}
		
		int min = Math.min(dp[N][0], dp[N][1]);
		min = Math.min(min, dp[N][2]);
		System.out.println(min);
		
	}
}