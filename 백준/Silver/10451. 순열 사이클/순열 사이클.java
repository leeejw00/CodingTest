import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            graph = new ArrayList<>();
            visited = new boolean[N+1];

            for(int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 배열 idx 이용해 그래프 생성
            for(int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());

                graph.get(i).add(num);
            }

            // 방문하지 않은 정점 돌며 순열 사이클 개수 탐색
            int cnt = 0;
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    bfs(i);
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}