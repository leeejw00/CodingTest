import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            Stack<Character> stack = new Stack<>();
            boolean ans = true;
            String str = br.readLine();
            if(str.equals(".")) break;

            for(int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                if(cur == '(' || cur == '[')
                    stack.push(cur);
                else if(cur == ')') {
                   if(!stack.empty() && stack.peek() == '(') {
                       stack.pop();
                   }else {
                       ans = false;
                       break;
                   }
                }
                else if(cur == ']') {
                    if(!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    }else {
                        ans = false;
                        break;
                    }
                }
            }
            if(stack.empty() && ans) {
                System.out.println("yes");
            }else if((stack.empty() && !ans) || !stack.empty()) {
                System.out.println("no");
            }
        }
    }
}