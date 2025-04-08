import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isSelected;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new int[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 각 선거구별 인구 수 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 그래프 연결
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int linkedNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < linkedNum; j++) {
                int num = Integer.parseInt(st.nextToken());

                graph.get(i).add(num-1);
                graph.get(num-1).add(i);
            }
        }

        isSelected = new boolean[N];
        comb(0);

        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void comb(int idx) {
        if (idx == N) { 
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            // true이면 A구역, false이면 B구역
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) A.add(i);
                else B.add(i);
            }

            visited = new boolean[N];

            // 한 선거구에 모든 구역 있는 경우 불가
            if (A.size() == 0 || B.size() == 0) {
                return;
            }

            // 모두 연결되어 있다면 인구 수 차이 계산
            if (bfs(A) && bfs(B)) {
                calP();
            }

            return;
        }

        isSelected[idx] = true;
        comb(idx+1);
        isSelected[idx] = false;
        comb(idx+1);
    }

    static boolean bfs(List<Integer> list) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[list.get(0)] = true;
        q.offer(list.get(0));

        int cnt = 1; // 연결된 선거구 개수

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph.get(curr)) {
                if (visited[next]) continue;

                // 현재 그룹에 포함되어 있는지 확인
                // 그래프에서 연결되어 있지만 현재 구역에 없다면 넘기기
                if (!list.contains(next)) continue;

                visited[next] = true;
                q.offer(next);
                cnt++;
            }
        }

        if (cnt == list.size())
            return true;
        else
            return false;
    }

    // 인구수 차이 계산해주고 min 갱신
    static void calP() {
        int Anum = 0;
        int Bnum = 0;

        for (int i = 0; i < N; i++) {
            if (isSelected[i])
                Anum += people[i];
            else
                Bnum += people[i];
        }

        min = Math.min(Math.abs(Anum - Bnum), min);
    }
}