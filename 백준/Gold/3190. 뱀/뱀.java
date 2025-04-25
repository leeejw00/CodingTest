import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};
    static HashMap<Integer, String> hashMap = new HashMap<>(); // 뱀 방향 변환 정보 저장
    static List<int []> snake = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1; // 사과 있는 곳 : 1
        }

        // 뱀 방향 변환 정보 hashMap에 저장
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            hashMap.put(time, dir);
        }

        solve();
    }

    public static void solve() {
        int r = 0, c = 0;
        int time = 0;
        int d = 0;
        snake.add(new int[] {0, 0}); // 뱀 처음 위치 추가

        while (true) {
            time++;

            // 뱀 이동
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 벽이거나, 뱀 몸통 만나면 종료
            if (isFinish(nr, nc)) {
                break;
            }

            // 사과 유무시 처리
            if (map[nr][nc] == 1) {
                map[nr][nc] = 0; // 사과 먹기
            } else {
                snake.remove(0); // 없으면 꼬리 제거
            }
            snake.add(new int[] {nr, nc}); // 뱀 머리 위치 추가 (이동)

            // 방향 전환 시간 만난 경우 방향 변경
            if (hashMap.containsKey(time)) {
                if (hashMap.get(time).equals("D")) {
                    d = (d+1) % 4;
                } else {
                    d = (d+3) % 4;
                }
            }

            // 현재 값 업데이트
            r = nr;
            c = nc;
        }

        System.out.println(time);
    }

    static boolean isFinish(int nr, int nc) {
        // 벽인 경우
        if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
            return true;
        }

        // 뱀 몸통인 경우
        for (int i = 0; i < snake.size(); i++) {
            int[] curr = snake.get(i);
            if (nr == curr[0] && nc == curr[1]) {
                return true;
            }
        }

        return false;
    }
}