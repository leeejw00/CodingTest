import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 편의점 개수

            visited = new boolean[N + 2];

            // 집, 편의점, 락페 좌표 저장
            int[][] v = new int[N + 2][2];
            for(int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 2; j++) {
                    v[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 인접리스트 (그래프)
            graph = new ArrayList<>();
            for(int i = 0; i < N + 2; i++) {
                graph.add(new ArrayList<>());
            }

            // 두 정점 사이 바로 이동 가능하다면 그래프 연결
            for(int i = 0; i < N + 2; i++) {
                for(int j = i + 1; j < N + 2; j++) {
                    int cx = v[i][0];
                    int cy = v[i][1];
                    int nx = v[j][0];
                    int ny = v[j][1];

                    // 두 좌표 사이의 거리가 1000m 이하면 바로 이동 가능 -> 연결
                    if(manhattan(cx, cy, nx, ny) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    };
                }
            }

            String ans = bfs() ? "happy" : "sad";
            System.out.println(ans);
        }
    }

    // 맥주 20개로 갈 수 있는 거리(1000m)인지 계산 (맨해튼 거리)
    private static int manhattan(int currX, int currY, int nextX, int nextY) {
        return Math.abs(currX - nextX) + Math.abs(currY - nextY);
    }

    private static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // 출발 지점
        visited[0] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();

            if(curr == N + 1) { // 도착지점을 만난 경우
                return true;
            }

            for(int next : graph.get(curr)) {
                if(visited[next]) continue;

                visited[next] = true;
                q.offer(next);
            }
        }

        return false;
    }
}