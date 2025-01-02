import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(A);

        while (true) {
            int beforeNum = list.get(list.size() - 1);

            int nextNum = 0;
            while(beforeNum != 0) {
                nextNum += (int) Math.pow(beforeNum % 10, (double) P);
                beforeNum /= 10;
            }

            // 반복되는 수 등장하면 idx 반환 (idx가 개수와 같음)
            if(list.contains(nextNum)) {
                int ans = list.indexOf(nextNum);
                System.out.println(ans);
                break;
            }

            list.add(nextNum);
        }
    }
}