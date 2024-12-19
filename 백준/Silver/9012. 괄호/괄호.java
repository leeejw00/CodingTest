import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            Stack<Character> stack = new Stack<>();

            String str = br.readLine();

            String ans = "YES";
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        ans = "NO";
                        break;
                    }
                }
                else {
                    stack.push(str.charAt(i));
                }
            }

            if(!stack.isEmpty())
                ans = "NO";

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}