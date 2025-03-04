import java.util.*;

class Solution {
    static LinkedList<LinkedList<Integer>> tree;
    static boolean[] visited;

    public int solution(int n, int[][] wires) {
        // tree로 구현할 링크드리스트 생성
        tree = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new LinkedList<>());
        }

        // tree 연결
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;

        // 완전탐색으로 송전탑 최소 차이 구하기
        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n+1];

            int a = wires[i][0];
            int b = wires[i][1];

            // 현재 연결망 끊어주기
            tree.get(a).remove(Integer.valueOf(b));
            tree.get(b).remove(Integer.valueOf(a));

            // bfs로 두 전력망의 송전탑 개수 구하고 최소값 비교
            visited[a] = true;
            int cntA = bfs(a);

            int cntB = n - cntA;
            // visited[b] = true;
            // int cntB = bfs(b);

            min = Math.min(min, Math.abs(cntA - cntB));

            // 현재 상태 탐색 끝났으면 다시 연결해주기 (복구작업)
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        return min;
    }

    // 해당 전력망의 송전탑 개수 구하기
    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int cnt = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : tree.get(curr)) {
                if (visited[next]) continue;

                visited[next] = true;
                q.offer(next);
                cnt++;
            }
        }

        return cnt;
    }
}