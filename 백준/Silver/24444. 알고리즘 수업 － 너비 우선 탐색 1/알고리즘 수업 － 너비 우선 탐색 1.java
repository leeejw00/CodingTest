import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] order; //방문 순서 저장 배열
    static int count = 1;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점
        int M = Integer.parseInt(st.nextToken()); //간선
        int R = Integer.parseInt(st.nextToken()); //시작 정점

        visited = new boolean[N+1];
        order = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            graph[B].add(A);
        }

        for(int i=1; i<N+1; i++){
            Collections.sort(graph[i]);
        }

        visited[R] = true;
        order[R] = count;
        bfs(R);

        for(int i=1; i<order.length; i++){
            System.out.println(order[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int next : graph[curr]){

                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    order[next] = ++count;
                }
            }
        }
    }
}
