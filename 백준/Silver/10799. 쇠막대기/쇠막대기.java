import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int sticks = countStick(input);

        System.out.println(sticks);
    }

    private static int countStick(String input) {
        Stack<Character> stack = new Stack<>();

        int sticks = 0;
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if(curr == '(') {
                stack.push(curr);
            } else {
                stack.pop();
                if(input.charAt(i-1) == '(') {
                    sticks += stack.size();
                } else {
                  sticks += 1;
                }
            }
        }

        return sticks;
    }
}