import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        order = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            graph[B].add(A);
        }

        //오름차순 위한 정렬
        for(int i=1; i<N+1; i++){
            Collections.sort(graph[i]);
        }

        order[R] = 1;
        dfs(R);

        for(int i=1; i<N+1; i++){
            System.out.println(order[i]);
        }
    }

    static void dfs(int start) {
        visited[start] = true;
        for(int i=0; i<graph[start].size(); i++){
            int next = graph[start].get(i);
            if(!visited[next]){
                visited[next] = true;
                order[next] = ++cnt;
                dfs(next);
            }
        }
    }
}