import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = N;
        for(int i=0; i<N; i++) {
            String word = br.readLine();
            boolean[] check = new boolean[26];
            check[word.charAt(0) - 97] = true;

            for(int j=1; j<word.length(); j++) {
                char curr = word.charAt(j);
                if(curr == word.charAt(j-1)) continue;

                if(check[curr - 97]) {
                    cnt--;
                    break;
                } else {
                    check[curr - 97] = true;
                }
            }
        }
        System.out.println(cnt);
    }
}