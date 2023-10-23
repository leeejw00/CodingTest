import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {1, 0, -1, 0}; //하 우 상 좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int key = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int r = 0;
        int c = 0;
        int num = N*N;
        arr[r][c] = num;

        int dir = 0;
        while(num > 1) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != 0)
                dir = (dir + 1) % 4;

            r += dr[dir];
            c += dc[dir];
            arr[r][c] = --num;
        }

        int ansR = 0;
        int ansC = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == key) {
                    ansR = i;
                    ansC = j;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		sb.append(arr[i][j] + " ");
        	}
        	sb.append("\n");
        }
        sb.append((ansR+1) + " " + (ansC+1));
        System.out.println(sb);
    }
}