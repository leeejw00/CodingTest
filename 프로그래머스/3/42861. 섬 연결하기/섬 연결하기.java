import java.util.*;

class Solution {
//     static int[] parent;
    
//     // todo. 크루스칼 알고리즘
//     public int solution(int n, int[][] costs) {
//         // 비용 기준 오름차순 정렬
//         Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

//         // 루트 노드 배열 초기화
//         parent = new int[n];
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//         }
        
//         // 크루스칼 알고리즘 - 최소비용의 간선부터 하나씩 연결
//         int totalCost = 0;
//         int edgesLinked = 0;
//         for (int[] edge : costs) {
//             int v1 = edge[0], v2 = edge[1], cost = edge[2];

//             // 사이클이 생기지 않게 다리 연결 -> union-find 이용
//             if (find(v1) != find(v2)) {
//                 union(v1, v2);
//                 totalCost += cost;
//                 edgesLinked++;
//             }

//             // 간선의 개수가 n-1이 되면 모든 섬 연결된 상태 (mst 완성)
//             if (edgesLinked == n-1) break;
//         }
        
//         return totalCost;
//     }
    
//     // find 연산 - x의 루트 노드 찾기
//     static int find(int x) {
//         if (parent[x] == x) return x;
//         return parent[x] = find(parent[x]);
//     }
    
//     // union 연산 - 두 집합 합치기 (연결)
//     static void union(int x, int y) {
//         int rootX = find(x);
//         int rootY = find(y);
        
//         if (rootY != rootX) {
//             parent[rootY] = rootX;
//         }
//     }
    
    // todo. 프림 알고리즘 - 노드 중심 접근
    public int solution(int n, int[][] costs) {
        // 인접리스트로 그래프 생성
        ArrayList<int []>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int[] edge : costs) {
            int v1 = edge[0], v2 = edge[1], cost = edge[2];

            graph[v1].add(new int[] {v2, cost});
            graph[v2].add(new int[] {v1, cost});
        }

        boolean[] visited = new boolean[n];

        // 우선순위큐 -> 해당 정점에서 갈 수 있는 가장 낮은 가중치의 경우가 먼저 나옴
        // 우선순위큐 생성 및 시작점 삽입
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[] {0, 0}); // 시작섬, 처음 가중치

        int totalCost = 0;
        int edgesLinked = 0;

        // 모든 섬 방문할 때까지 반복
        while (!pq.isEmpty() && edgesLinked < n) {
            int[] curr = pq.poll();
            int node = curr[0], cost = curr[1];

            // 이미 방문했으면 넘기기
            if (visited[node]) continue;

            // 그렇지 않으면 방문하기
            visited[node] = true;
            totalCost += cost;
            edgesLinked++;

            // 현재 정점에서 갈 수 있는 다음 정점 탐색 (연결되어있는)
            for (int[] next : graph[node]) {
                int nextNode = next[0];

                // 방문하지 않은 곳이면 pq에 넣어주기
                if (!visited[nextNode]) {
                    pq.add(next);
                }
            }
        }

        return totalCost;
    }
}