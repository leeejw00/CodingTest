import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, cnt;
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> houseList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    int houseCnt = bfs(i,j);
                    houseList.add(houseCnt);
                }
            }
        }
        Collections.sort(houseList);

        StringBuilder sb = new StringBuilder();
        sb.append(houseList.size()).append("\n");

        for(int houses : houseList) {
            sb.append(houses).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int row, int col) {
        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        cnt = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(map[nr][nc] == 0 || visited[nr][nc]) continue;

                q.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                cnt++;
            }
        }

        return cnt;
    }
}