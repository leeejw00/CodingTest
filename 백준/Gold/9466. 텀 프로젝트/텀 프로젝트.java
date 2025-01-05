import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt;
    static boolean[] visited, checked;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            cnt = 0;
            checked = new boolean[N+1];
            visited = new boolean[N+1];
            arr = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                int picked = Integer.parseInt(st.nextToken());
                arr[i] = picked;
            }

            for(int i = 1; i <= N; i++) {
                if(!checked[i]) {
                    dfs(i);
                }
            }

            System.out.println(N-cnt);
        }
    }

    static void dfs(int idx) {
        if(checked[idx]) return; // 이미 검사한 곳이면 dfs x

        if(visited[idx]) { // 검사 안했지만, 방문한 곳 => 사이클
            checked[idx] = true;
            cnt++; // 팀에 속한 인원 증가
        }

        // 아직 검사하지 않은 경우 dfs로 팀 구성 가능성 검사
        visited[idx] = true;
        dfs(arr[idx]);

        visited[idx] = false; // 재귀나오면 방문체크 초기화
        checked[idx] = true; // 사이클 아니지만 검사했음 표시 (재귀이후)
    }
}