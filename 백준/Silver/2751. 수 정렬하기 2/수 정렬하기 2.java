import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list); // O(n) ~ O(nlogn)
                                // Arrays.sort() ->  O(n^2) ~ O(nlogn)

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);
    }
}