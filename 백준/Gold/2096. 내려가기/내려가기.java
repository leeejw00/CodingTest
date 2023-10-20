import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] score = new int[N+1][3]; //점수 입력
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] maxS = new int[N+1][3];
		int[][] minS = new int[N+1][3];
		
		maxS[1][0] = minS[1][0] = score[1][0];
		maxS[1][1] = minS[1][1] = score[1][1];
		maxS[1][2] = minS[1][2] = score[1][2];
		
		for(int i=2; i<=N; i++) {
			maxS[i][0] = Math.max(maxS[i-1][0], maxS[i-1][1]) + score[i][0];
			maxS[i][2] = Math.max(maxS[i-1][1], maxS[i-1][2]) + score[i][2];
			maxS[i][1] = Math.max(Math.max(maxS[i-1][0], maxS[i-1][1]), maxS[i-1][2]) + score[i][1];
			
			minS[i][0] = Math.min(minS[i-1][0], minS[i-1][1]) + score[i][0];
			minS[i][2] = Math.min(minS[i-1][1], minS[i-1][2]) + score[i][2];
			minS[i][1] = Math.min(Math.min(minS[i-1][0], minS[i-1][1]), minS[i-1][2]) + score[i][1];
		}
		
		int max = Math.max(maxS[N][0], maxS[N][1]);
		max = Math.max(max, maxS[N][2]);
		int min = Math.min(minS[N][0], minS[N][1]);
		min = Math.min(min, minS[N][2]);
		System.out.println(max+" "+min);
		
	}
}