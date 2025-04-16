import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] originMap;
    static int[][] turnArr; // 초기 회전 연산 저장
    static int[] pickedTurnOrder; // 뽑은 회전 순서 저장할 배열
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        originMap = new int[N+1][M+1]; 
        turnArr = new int[K][3];
        pickedTurnOrder = new int[K];
        visited = new boolean[K];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                turnArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);

        System.out.println(min);
    }

    // 순열로 회전순서 정하기
    static void perm(int depth) {
        if (depth == K) {
            turnMap(); // 배열 회전 시키기
            return;
        }

        // 뽑기
        for (int i = 0; i < K; i++) {
            if (visited[i]) continue;

            pickedTurnOrder[depth] = i;
            visited[i] = true;
            perm(depth + 1);
            visited[i] = false;
        }
    }

    // 배열 회전시키기
    static void turnMap() {
        // 회전시키기 위해서 기존 맵 복사
        int[][] copyMap = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copyMap[i][j] = originMap[i][j];
            }
        }

        // 뽑은 회전 순서대로 배열 회전
        for (int i = 0; i < K; i++) {
            int idx = pickedTurnOrder[i];
            int r = turnArr[idx][0];
            int c = turnArr[idx][1];
            int S = turnArr[idx][2];

            // 테두리 한 겹씩 돌리기 (s번)
            for (int s = 1; s <= S; s++) {
                // 위쪽
                int upTmp = copyMap[r-s][c+s]; // 가장 오른쪽 끝 값 저장
                for (int y = c+s; y > c-s; y--) {
                    copyMap[r-s][y] = copyMap[r-s][y-1]; // 오른쪽으로 값 당김
                }

                // 오른쪽
                int rightTmp = copyMap[r+s][c+s]; // 아래쪽 끝 값 저장
                for (int x = r+s; x > r-s; x--) {
                    copyMap[x][c+s] = copyMap[x-1][c+s];
                }
                copyMap[r-s+1][c+s] = upTmp; // 위에서 밀려나온 값 채움

                // 아래쪽
                int leftTmp = copyMap[r+s][c-s]; // 아래 왼쪽 끝 값 저장
                for (int y = c-s; y < c+s; y++) { // 왼쪽에서 오른쪽으로 당김
                    copyMap[r+s][y] = copyMap[r+s][y+1];
                }
                copyMap[r+s][c+s-1] = rightTmp; // 오른쪽에서 밀려난 값 채움

                // 왼쪽
                for (int x = r-s; x < r+s; x++) { // 위 -> 아래로 당김
                    copyMap[x][c-s] = copyMap[x+1][c-s];
                }
                copyMap[r+s-1][c-s] = leftTmp;
            }
        }
        calSum(copyMap);
    }

    static void calSum(int[][] copyMap) {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += copyMap[i][j];
            }

            min = Math.min(min, sum);
        }
    }
}