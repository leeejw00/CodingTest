import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int V, node;
    static int max = 0;
    static boolean[] visited;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 트리 입력
        StringTokenizer st;
        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken()); // 현재 정점

            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;

                int dis = Integer.parseInt(st.nextToken()); // 거리

                graph.get(v).add(new Node(num, dis));
                graph.get(num).add(new Node(v, dis));
            }
        }

        // 한 노드에서 가장 먼 노드 찾은 후 저장
        visited = new boolean[V+1];
        dfs(1, 0);

        // 저장한 노드부터 가장 먼 노드까지 거리 구하기
        visited = new boolean[V+1];
        dfs(node, 0);

        System.out.println(max);
    }

    static void dfs(int v, int dis) {
        if(dis > max) {
            max = dis;
            node = v;
        }

        visited[v] = true;

        for(Node next : graph.get(v)) {
            if(visited[next.value]) continue;

            dfs(next.value, next.distance + dis);
        }
    }

    static class Node {
        int value; // 정점 번호
        int distance; // 거리

        public Node (int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}

// 트리 : 모든 정점이 사이클 없이 연결되어 있는 그래프
// 임의의 노드로부터 가장 먼 노드 찾기, 두 정점 사이 거리 구하기