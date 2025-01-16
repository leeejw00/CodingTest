import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        partition(0, 0, N);

        System.out.println(sb);
    }

    static void partition(int row, int col, int size) {

        // 같은 수이면 해당 수 출력
        if (isSameNum(row, col, size)) {
            sb.append(map[row][col]);
            return;
        }

        // 같은 수 아니면 4개의 영상으로 나누기
        size = size / 2;

        // 각 depth 시작하고 끝날 때 괄호
        sb.append('(');

        partition(row, col, size); // 2사분면
        partition(row, col + size, size); // 1사분면
        partition(row + size, col, size); // 3사분면
        partition(row + size, col + size, size); // 4사분면

        sb.append(')');
    }

    static boolean isSameNum (int row, int col, int size) {
        int num = map[row][col]; // 기준이 되는 수

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(num != map[i][j])
                    return false;
            }
        }

        return true;
    }
}