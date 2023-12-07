import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	static int min = 64; //8*8
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String colors = br.readLine();
			for(int j=0; j<m; j++) {
				if(colors.charAt(j) == 'W') {
					map[i][j] = true; //w는 true, b는 false로 저장
				}else {
					map[i][j] = false;
				}
			}
		}
		
		//확인 가능 시작 범위
		for(int i=0; i<n-7; i++) {
			for(int j=0; j<m-7; j++) {
				find(i,j);
			}
		}
		
		System.out.println(min);
	
	}

	static void find(int x, int y) {
		int cnt = 0;
		boolean check = map[x][y]; //체스판 첫번째 칸의 색 저장 (T/F)
		
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(map[i][j] != check) {
					cnt++;
				}
				check = !check; //한 칸씩 색 변경되어야 함
			}
			check = !check;
		}
		
		cnt = Math.min(cnt, 64-cnt); //현재와 반대의 색깔 기준으로 바꿔 칠했을 경우 비교하여 최소값 저장
		min = Math.min(min, cnt);	
	}

}