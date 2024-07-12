import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();

            String shapes = br.readLine();
            for(int a = 0; a < shapes.length(); a++) {
                char currShape = shapes.charAt(a);

                if(currShape == '(') {
                    stack.push(currShape);
                }
                else if(currShape == ')') {
                   if(stack.isEmpty()) {
                       stack.push('N');
                       break;
                   }
                   else if(stack.peek() == '(')
                       stack.pop();
                }
            }

            if(stack.isEmpty())
                sb.append("YES");
            else
                sb.append("NO");
            sb.append('\n');
        }
        System.out.println(sb);
    }
}