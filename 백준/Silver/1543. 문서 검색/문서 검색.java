import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String source = br.readLine();
        String target = br.readLine();

        int idx = 0;
        int cnt = 0;
        while(idx < source.length()) {
            Boolean isSame = isSameWord(source.substring(idx), target);

            if(isSame) {
                idx += target.length();
                cnt++;
            } else {
                idx++;
            }
        }

        System.out.println(cnt);
    }

    static private Boolean isSameWord(String source, String target) {
        for(int i = 0; i < target.length(); i++) {
            int j = 0;
            while(i + j < target.length() && j < source.length()
            && target.charAt(i + j) == source.charAt(j)) {
                j++;
            }

            if(j == target.length()) return true;
        }

        return false;
    }
}