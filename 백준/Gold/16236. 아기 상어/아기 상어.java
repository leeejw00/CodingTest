import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, curR, curC;
    static int[][] map;
    static int[] dr = {0, -1, 1, 0}; // 상 좌 우 하 (우선순위)
    static int[] dc = {-1, 0, 0, 1}; 
    static int size = 2; // 아기상어 초기 사이즈
    static int eat = 0; // size업 하기 위해 먹은 물고기 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    curR = i;
                    curC = j;
                    map[i][j] = 0; // 상어가 있는 위치는 지나갈 수 있음
                }
            }
        }

        // bfs로 먹이 찾기 -> 먹기 반복
        int time = 0;
        while (true) {
            int res = bfs();
            if (res == -1) break;

            time += res;
        }

        System.out.println(time);
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(curR, curC, 0)); // 탐색 시작 위치, 거리
        boolean[][] visited = new boolean[N][N];
        visited[curR][curC] = true;

        // 먹을 수 있는 물고기들 저장할 fishList
        List<Node> fishList = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int dis = curr.dis;

            if (dis > minDist) break; // 최소 거리 초과하면 굳이 탐색 x

            // 해당 위치의 물고기 먹을 수 있으면
            if (map[r][c] > 0 && map[r][c] < size) {
                fishList.add(curr); // 리스트에 저장
                minDist = dis; // 최소 거리 갱신
            }

            // 현재 위치에서 갈 수 있는 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 넘어가면 x, 이미 방문한 곳 x, 물고기 크기 자신보다 크다면 x
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc] || map[nr][nc] > size) continue;

                // 이동
                q.add(new Node(nr, nc, dis + 1));
                visited[nr][nc] = true;
            }
        }

        // 먹을 수 있는 물고기 없는 경우
        if (fishList.isEmpty()) return -1;

        // 먹을 수 있는 물고기들 중에 우선순위 가장 높은 물고기 찾기 위해 정렬
        // 거리는 위에서 이미 차단했기 때문에 r, c만 보면 됨
        Collections.sort(fishList, (o1, o2) -> {
            if (o1.c != o2.c) return o1.r - o2.r;
            return o1.c - o2.c;
        });

        // 우선순위대로 정렬 완료 된 상태니 가장 첫번째 물고기가 타겟, 먹기
        Node target = fishList.get(0);
        curR = target.r;
        curC = target.c;
        map[curR][curC] = 0;
        eat++;

        // 아기 상어 성장
        if (eat == size) {
            size++;
            eat = 0;
        }

        return target.dis;
    }

    // 물고기 좌표, 이동거리
    static class Node {
        int r;
        int c;
        int dis;

        public Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
}