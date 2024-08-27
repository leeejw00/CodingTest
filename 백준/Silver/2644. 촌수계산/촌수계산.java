import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList;
    static int ans = -1; // 만나지 못한 경우로 초기화

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정점 개수
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int e = Integer.parseInt(br.readLine()); // 간선 개수

        // 인접리스트
        adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        dfs(start, end, 0);
        System.out.println(ans);
    }

    private static void dfs(int start, int end, int cnt) {
        if(start == end) {
            ans = cnt;
            return;
        }
        
        visited[start] = true;

        for(int next : adjList.get(start)) {
            if(visited[next]) continue;
            dfs(next, end, cnt + 1);
        }
    }
}