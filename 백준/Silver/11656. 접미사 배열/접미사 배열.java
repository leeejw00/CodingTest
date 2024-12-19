import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr = new String[s.length()];

        StringBuilder sb;
        for(int i = 0; i < s.length(); i++) {
            sb = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
            }
            arr[i] = String.valueOf(sb);
        }

        Arrays.sort(arr);

        for(String val : arr) {
            System.out.println(val);
        }
    }
}