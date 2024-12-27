import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) {
            iter.next();
        }

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String key = st.nextToken();
            if(key.equals("L")) {
                if(!iter.hasPrevious()) continue;
                iter.previous();
            }
            else if(key.equals("D")) {
                if(!iter.hasNext()) continue;
                iter.next();
            }
            else if(key.equals("B")) {
                if(!iter.hasPrevious()) continue;
                iter.previous();
                iter.remove();
            }
            else {
                char c = st.nextToken().charAt(0);
                iter.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}