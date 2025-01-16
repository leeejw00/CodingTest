import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        // 두 포인터
        int p1 = 0, p2 = 0;
        while (p1 < N && p2 < M) {

            if(arrA[p1] <= arrB[p2]) {
                sb.append(arrA[p1++]).append(" ");
            } else {
                sb.append(arrB[p2++]).append(" ");
            }
        }

        // 두 배열길이가 다를 때 한 포인터가 배열끝까지 오면
        // 다른 배열의 값을 다 넣지 못하는 경우 발생
        // 남아있는 값 넣어주기
        if(p1 == N) {
            for(int i = p2; i < M; i++) {
                sb.append(arrB[i]).append(" ");
            }
        } else {
            for(int i = p1; i < N; i++) {
                sb.append(arrA[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}