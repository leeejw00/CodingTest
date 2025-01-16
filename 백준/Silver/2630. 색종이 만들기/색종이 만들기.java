import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, white, blue;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0;
        blue = 0;

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    // 분할정복
    static void partition(int row, int col, int size) { // 탐색 출발 좌표, 사이즈

        // 잘린 종이가 같은 색이면 개수 증가
        if(isSameColor(row, col, size)) {
            if (map[row][col] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        // 모두 같은 색이 아니면 색종이 4등분으로 자르기
        size = size / 2;

        partition(row, col, size); // 2사분면
        partition(row, col + size, size); // 1사분면
        partition(row + size, col, size); // 3사분면
        partition(row + size, col + size, size); // 4사분면
    }


    static boolean isSameColor(int row, int col, int size) {
        int color = map[row][col]; // 출발좌표 색 (출발좌표 색과 모두 같은색이면 true)

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(map[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}