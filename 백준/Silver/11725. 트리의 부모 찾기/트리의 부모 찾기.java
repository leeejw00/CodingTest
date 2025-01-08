import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = new int[N+1]; // 각 노드의 부모 저장할 배열
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 생성
        StringTokenizer st;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            tree.get(from).add(to);
            tree.get(to).add(from);
        }

        // 루트노드부터 탐색
        visited[1] = true;
        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for(int child : tree.get(curr)) {
                if(visited[child]) continue;

                q.offer(child);
                visited[child] = true;
                parent[child] = curr;
            }
        }
    }
}
// 트리는 어떤 정점의 인접한 정점은 반드시 부모 노드 혹은 자식 노드
// 루트 노드에서부터 탐색하면 특정 노드의 부모 노드 알 수 있음