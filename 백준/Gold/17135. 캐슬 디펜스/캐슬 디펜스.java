import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D, max = 0;
    static int[][] originMap;
    static int[] archerPositions = new int[3]; // 궁수 3명 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합 (궁수 3명 배치)
        comb(0,0);

        System.out.println(max);
    }

    // 궁수 3명 배치 (M열 중 세 곳의 위치 정하기)
    static void comb(int start, int depth) {
        if (depth == 3) {
            simulate(); // 궁수 3명을 배치했으면 시물레이션 진행
            return;
        }

        for (int i = start; i < M; i++) {
            archerPositions[depth] = i;
            comb(i + 1, depth + 1);
        }
    }

    // 시뮬레이션 (궁수 공격, 적 이동)
    static void simulate() {
        int[][] map = copyMap(originMap); // 이번 시뮬레이션에서 쓸 map 만들기
        int killCnt = 0;

        for (int turn = 0; turn < N; turn++) {
            List<Point> targets = new ArrayList<>();

            // 각 궁수마다 적을 찾음
            for (int archer : archerPositions) {
                Point target = bfs(map, N, archer); // 궁수 위치로부터 가장 가까운 적 찾기

                if (target != null) {

                    // 중복 타겟인지 확인
                    boolean alreadyTargeted = false;
                    for (Point p : targets) {
                        if (p.x == target.x && p.y == target.y) {
                            alreadyTargeted = true;
                            break;
                        }
                    }

                    // 중복 타겟이 아니면 targets리스트에 추가
                    if (!alreadyTargeted) {
                        targets.add(target);
                    }
                }
            }
            // 한 턴 내의 타겟이 된 적들 리스트에 추가된 상태

            // 궁수가 적 공격
            for (Point p : targets) {
                if (map[p.x][p.y] == 1) {
                    map[p.x][p.y] = 0;
                    killCnt++;
                }
            }

            // 적 한 칸 아래로 이동
            moveEnemies(map);
        }

        max = Math.max(max, killCnt);
    }

    // bfs로 가장 가까운 적 한 명 찾기
    static Point bfs(int[][] map, int x, int y) { // 현재 게임 상태 (적 위치), bfs 시작 좌표 (궁수 위치)
        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x-1, y, 1)); // 궁수는 성 아래에 있으니 한칸 위에서 시작 (성 바로 위 행부터 적 찾기)
        visited[x-1][y] = true;

        // 좌, 상, 우 순서로 탐색 (왼쪽 우선)
        int[] dx = {0, -1, 0};
        int[] dy = {-1, 0, 1};

        while (!q.isEmpty()) {
            Point cur = q.poll();

            // 적 찾았으면 해당 적이 가장 가까운 적이므로 return
            if (map[cur.x][cur.y] == 1) {
                return cur;
            }

            // 거리 제한 (이 조건 없으면 D+1, D+2까지 탐색하게 됨)
            if (cur.dist == D) continue;

            // 세방향 왼쪽부터 탐색
            for (int d = 0; d < 3; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, cur.dist + 1));
            }
        }

        // 공격할 적이 없는 경우
        return null;
    }

    // 적을 한 칸 아래로 이동
    static void moveEnemies(int[][] map) {
        for (int i = N-1; i > 0; i--) {
            map[i] = Arrays.copyOf(map[i-1], M);
        }
        Arrays.fill(map[0], 0); // 맨 윗줄은 비게 됨
    }

    // 맵 복사
    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = Arrays.copyOf(map[i], M);
        }
        return newMap;
    }

    // 좌표 + 거리 저장용 클래스
    static class Point {
        int x, y, dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}