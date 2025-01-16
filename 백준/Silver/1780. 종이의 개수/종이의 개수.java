import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minus, zero, plus; // -1, 0, 1 의 개수
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minus = 0;
        zero = 0;
        plus = 0;

        partition(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void partition (int row, int col, int size) { // 출발좌표, 사이즈

        // 종이가 모두 같은 수라면 개수 증가
        if (isSameNum(row, col, size)) {
            if(map[row][col] == -1) {
                minus++;
            } else if(map[row][col] == 0) {
                zero++;
            } else {
                plus++;
            }

            return;
        }

        // 그렇지 않으면 사이즈 나누기 3
        size = size / 3;

        // 재귀 9개 (왼쪽 위부터 오른쪽 아래 9등분 순서로)
        partition(row, col, size);
        partition(row, col + size, size);
        partition(row, col + size * 2, size);

        partition(row + size, col, size);
        partition(row + size, col + size, size);
        partition(row + size, col + size * 2, size);

        partition(row + size * 2, col, size);
        partition(row + size * 2, col + size, size);
        partition(row + size * 2, col + size * 2, size);
    }

    static boolean isSameNum (int row, int col, int size) {
        int num = map[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(num != map[i][j])
                    return false;
            }
        }

        return true;
    }
}