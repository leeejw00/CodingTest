import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int map[][] = new int[10][10];
    static int papers[] = new int[6]; 
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 초기 맵
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 색종이 크기 별 개수 저장
        for (int i = 1; i <= 5; i++) {
            papers[i] = 5;
        }

        // 완전탐색 + 백트래킹
        dfs(0, 0, 0);

        System.out.println(min == Integer.MAX_VALUE? -1 : min);
    }

    static void dfs(int r, int c, int cnt) { // 좌표, 붙인 색종이 개수
        // 맨 끝 좌표로 도달하였을 경우 색종이 개수 비교
        if (r >= 9 && c > 9) {
            min = Math.min(min, cnt);
            return;
        }

        // 최소값을 구해야 하는데 이미 최소값 초가했다면 더 탐색 x
        if (cnt > min) {
            return;
        }

        // 맨 오른쪽 열까지 도달했다면 한 행 아래로 이동
        if (c > 9) {
            dfs(r+1, 0, cnt);
            return;
        }

        // 탐색
        if (map[r][c] == 1) {
            // 큰 색종이부터 검사
            for (int i = 5; i > 0; i--) {
                // 해당 크기의 색종이가 남아있고 그 크기만큼 1이라면 색종이 붙임
                if (papers[i] > 0 && isPos(r, c, i)) {
                    attachPaper(r, c, i, 0); // 색종이 붙이기
                    papers[i]--;
                    dfs(r, c+i, cnt+1);

                    // 백트래킹
                    attachPaper(r, c, i, 1); // 색종이 떼기
                    papers[i]++;
                }
            }
        } else { // 1이 아니라면 다음 칸 이동
            dfs(r, c+1, cnt);
        }
    }

    // 해당 크기의 색종이 크기만큼 붙일 수 있는지 확인
    static Boolean isPos(int r, int c, int paperSize) {
        // map의 범위 넘기면 불가
        if (r + paperSize - 1 >= 10 || c + paperSize - 1 >= 10) {
            return false;
        }

        // 색종이 크기 안에 0이 있으면 불가
        for (int i = r; i < r + paperSize; i++) {
            for (int j = c; j < c + paperSize; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // 색종이 붙이기 or 떼기
    static void attachPaper(int r, int c, int paperSize, int state) {
        for (int i = r; i < r + paperSize; i++) {
            for (int j = c; j < c + paperSize; j++) {
                map[i][j] = state;
            }
        }
    }
}