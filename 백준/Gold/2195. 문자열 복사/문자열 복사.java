import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        int cnt = 0;
        int idx = 0;

        while (idx < P.length()) {
            int maxLength = getMaxLength(S,P.substring(idx));
            idx += maxLength;
            cnt++;
        }

        System.out.println(cnt);
    }

    private static int getMaxLength(String source, String target) {
        int maxLength = 0;

        for(int i = 0; i < source.length(); i++) {
            int j = 0;
            while(j < target.length() && i + j < source.length()
            && source.charAt(i + j) == target.charAt(j)) {
                j++;
            }
            maxLength = Math.max(maxLength, j);
        }

        return maxLength;
    }
}