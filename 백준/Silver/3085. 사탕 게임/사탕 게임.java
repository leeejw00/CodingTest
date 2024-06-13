import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 보드 초기화
        char[][] board = new char[N][N];
        for(int i=0; i<N; i++) {
            String row = br.readLine();
            for(int j=0; j<N; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int maxCandy = getMaxCandy(board, N); // 초기 상태에서 가장 긴 연속 부분 계산

        // 모든 인접한 두 칸에 대해 교환 후 계산
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                swap(board, i, j, i, j+1); // 행 교환
                maxCandy = Math.max(maxCandy, getMaxCandy(board, N));
                swap(board, i, j, i, j+1); // 사탕 위치 복귀

                swap(board, j, i, j+1, i); // 행 교환
                maxCandy = Math.max(maxCandy, getMaxCandy(board, N));
                swap(board, j, i, j+1, i); // 사탕 위치 복귀
            }
        }

        System.out.println(maxCandy);
    }

    // 교환 후 가장 긴 연속 부분 계산하는 메서드
    static int getMaxCandy(char[][] board, int N) {
        int maxRow = 1;
        int maxCol = 1;

        // 행에서 가장 긴 연속 부분 계산
        for(int i=0; i<N; i++) {
            int candy = 1;
            for(int j=0; j<N-1; j++) {
                if(board[i][j] == board[i][j+1]){
                    candy++;
                } else {
                    maxRow = Math.max(maxRow, candy);
                    candy = 1;
                }
            }
            maxRow = Math.max(maxRow, candy);
        }

        // 열에서 가장 긴 연속 부분 계산
        for(int i=0; i<N; i++) {
            int candy = 1;
            for(int j=0; j<N-1; j++) {
                if(board[j][i] == board[j+1][i]){
                    candy++;
                } else {
                    maxRow = Math.max(maxRow, candy);
                    candy = 1;
                }
            }
            maxRow = Math.max(maxRow, candy);
        }

        return Math.max(maxCol, maxRow);
    }

    static void swap(char[][] board, int i, int j, int x, int y) {
        char tmp = board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = tmp;
    }
}