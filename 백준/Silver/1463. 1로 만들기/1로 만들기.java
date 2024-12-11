import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		//초기값
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i=2; i<N+1; i++) {
			dp[i] = dp[i-1] + 1; //1 빼주기
			if(i%2==0) 
				dp[i] = Math.min(dp[i], dp[i/2] + 1); //1빼준 값과 2로 나눈값중 최소값 넣기
			if(i%3==0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		System.out.println(dp[N]);
	}//main
}