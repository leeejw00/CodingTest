import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {0, 1, 0, -1}; 
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int lines = Math.min(N,M)/2; //돌리는 구역 수
		for(int i=0; i<R; i++) {
			
			for(int j=0; j<lines; j++) {
				int r = j;
				int c = j;
				
				int temp = arr[r][c]; //(0,0) , (1,1) .. 마지막에 넣기 위해 저장
				
				int dir = 0;
				while(dir<4) {
					int nr = r +dr[dir];
					int nc = c + dc[dir];
					
					if(nr>=j && nc>=j && nr<N-j && nc<M-j) {
						arr[r][c] = arr[nr][nc];
						r = nr;
						c = nc;
					}else {
						dir++;
					}
				}
				arr[j+1][j] = temp;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}	
	}
}