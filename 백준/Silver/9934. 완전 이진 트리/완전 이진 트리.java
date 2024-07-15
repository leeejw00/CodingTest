import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] arr;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2,K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // depth에 맞게 노드를 저장하기 위한 list
        list = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }

        findRoot(0, arr.length-1, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            for(int node : list.get(i)) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void findRoot(int start, int end, int depth) {
        if(depth == K) {
            return;
        }

        // 가운데 있는 값이 부모 노드
        int mid = (start + end) / 2;

        //depth에 맞게 노드 삽입
        list.get(depth).add(arr[mid]);

        // 왼쪽 노드
        findRoot(start, mid-1, depth+1);

        // 오른쪽 노드
        findRoot(mid+1, end, depth+1);
    }
}