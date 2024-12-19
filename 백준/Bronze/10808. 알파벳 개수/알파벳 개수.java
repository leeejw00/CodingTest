import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[75];

        String alphabet = br.readLine();

        for(int i = 0; i < alphabet.length(); i++) {
            int num = alphabet.charAt(i) - '0';
            count[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 49; i < count.length; i++) {
            sb.append(count[i]).append(" ");
        }

        System.out.println(sb);
    }
}