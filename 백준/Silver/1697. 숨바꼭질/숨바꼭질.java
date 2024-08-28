import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] map;
    static int[] dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[100001];
        visited = new boolean[100001];

        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        int ans = bfs(N, K);

        System.out.println(ans);
    }

    private static int bfs(int start, int target) {
        Queue<int []> q = new LinkedList<>();
        visited[start] = true;
        q.offer(new int[] {start, 0}); // 현재 위치, 이동 시간

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int location = curr[0];
            int time = curr[1];

            if(location == target) {
                return time;
            }

            dir = new int[] {1, -1, location};

            for(int d = 0; d < 3; d++) {
                int next = location + dir[d];
                
                if(next > 100000 || next < 0 || visited[next]) continue;
                visited[next] = true;
                q.offer(new int[] {next, time + 1});
            }
        }

        return -1;
    }
}