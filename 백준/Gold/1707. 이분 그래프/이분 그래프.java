import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, V, E;
    static List<List<Integer>> graph;
    static int[] colors; // 방문x : 0, 빨 : 1, 파 : -1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for(int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점
            E = Integer.parseInt(st.nextToken()); // 간선

            graph = new ArrayList<>();
            colors = new int[V+1];

            for(int v = 0; v <= V; v++) {
                graph.add(new ArrayList<>());
            }

            for(int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            // 방문하지 않은 정점 돌면서 이분 그래프 확인
            boolean isBipartiteGraph = false;
            for(int i = 1; i <= V; i++) {
                if(colors[i] == 0) {
                    isBipartiteGraph = bfs(i, 1);
                }
                if(!isBipartiteGraph) break;
            }

            if(isBipartiteGraph) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean bfs(int start, int color) {
        // 시작 정점 색칠
        colors[start] = color;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int curr = q.poll();

            // 인접 그래프 탐색
            for(int next : graph.get(curr)) {
                // 인접한 정점이 같은 색이면 x
                if(colors[curr] == colors[next]) return false;

                // 색칠하지 않은곳이면 (방문x) 반대색으로 칠하기
                if(colors[next] == 0) {
                    colors[next] = colors[curr] * -1;
                    q.offer(next);
                }
            }
        }

        return true;
    }
}