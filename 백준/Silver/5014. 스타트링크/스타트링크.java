import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F;
    static int[] building;
    static boolean[] visited;
    static int[] dir;
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 건물 층 수
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 목표 위치
        int U = Integer.parseInt(st.nextToken()); // 위로 몇 칸 (우)
        int D = Integer.parseInt(st.nextToken()); // 아래로 몇 칸 (좌)

        building = new int[F + 1]; // 1 ~ F층
        visited = new boolean[F + 1];
        dir = new int[] {U, -D}; // 상 하 (우 좌)

        bfs(S, G);

        if(res == -1)
            System.out.println("use the stairs");
        else
            System.out.println(res);

    }

    private static void bfs(int s, int target) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {s, 0}); // 현재 위치, 이동 횟수
        visited[s] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int floor = curr[0];
            int moves = curr[1];

            if(floor == target) {
                res = moves;
                return;
            }

            for(int d = 0; d < 2; d++) {
                int next = floor + dir[d];

                if(next > F || next < 1 || visited[next]) continue;

                q.offer(new int[] {next, moves + 1});
                visited[next] = true;
            }
        }
    }
}