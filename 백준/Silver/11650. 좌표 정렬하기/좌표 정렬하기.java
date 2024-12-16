import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) { // x좌표가 같다면 y좌표 오름차순
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });

        // 람다식
//        Arrays.sort(arr, (o1, o2) -> {
//            if(o1[0] == o2[0]) { // x좌표가 같다면 y좌표 오름차순
//                return o1[1] - o2[1];
//            }
//            else {
//                return o1[0] - o2[0];
//            }
//        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}