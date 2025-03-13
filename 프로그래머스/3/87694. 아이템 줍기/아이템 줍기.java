import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dc = {-1, 1, 0, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // bfs 계산 편의 위해 map과 좌표값 모두 2배로 해줌
        map = new int[101][101];
        visited = new boolean[101][101];

        // map에 좌표 채워주기
        makeRouteOnMap(rectangle);

        // bfs탐색
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int []> q = new ArrayDeque<>();
        visited[startX][startY] = true;
        q.offer(new int[] {startX, startY, 0}); // 시작 좌표, 거리

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = curr[2];

            if (r == endX && c == endY) {
                return dis / 2;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= 101 || nc >= 101) continue;
                if (visited[nr][nc] || map[nr][nc] != 1) continue;

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, dis + 1});
            }
        }
        
        return 0;
    }

    // map에 좌표 채워주기
    // 바깥 테두리 : 1, 사각형 안쪽 : 2, 그 외 : 0
    static void makeRouteOnMap(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            // 테두리 1로 채워주기 (이미 2인 경우는 제외)
            for (int x = x1; x <= x2; x++) {
                if (map[x][y1] != 2) map[x][y1] = 1;
                if (map[x][y2] != 2) map[x][y2] = 1;
            }

            for (int y = y1; y <= y2; y++) {
                if (map[x1][y] != 2) map[x1][y] = 1;
                if (map[x2][y] != 2) map[x2][y] = 1;
            }

            // 사각형 안쪽 2로 채워주기
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 2;
                }
            }
        }
    }
}