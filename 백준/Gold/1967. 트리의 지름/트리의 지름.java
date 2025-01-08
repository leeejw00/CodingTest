import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, node;
    static int max = 0;
    static List<List<Node>> tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            tree.get(parent).add(new Node(child, dis));
            tree.get(child).add(new Node(parent, dis));
        }

        // 임의의 정점으로부터 가장 먼 정점 구하기
        visited = new boolean[n+1];
        dfs(1, 0);

        // 해당 정점에서부터 가장 먼 정점까지 거리 구하기
        visited = new boolean[n+1];
        dfs(node, 0);

        System.out.println(max);
    }

    static void dfs(int v, int dis) {
        if(dis > max) {
            max = dis;
            node = v;
        }

        visited[v] = true;

        for(Node next : tree.get(v)) {
            if(visited[next.value]) continue;

            dfs(next.value, next.dis + dis);
        }
    }

    static class Node {
        int value;
        int dis;

        public Node (int value, int dis) {
            this.value = value;
            this.dis = dis;
        }
    }
}