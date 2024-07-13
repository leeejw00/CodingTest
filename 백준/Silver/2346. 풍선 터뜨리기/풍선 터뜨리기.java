import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> list = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            list.add(new Balloon(i+1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        int moveNum = 0;

        while(!list.isEmpty()) {
            if(moveNum >= 0) {
                for(int i = 0; i < moveNum - 1; i++) {
                    list.addLast(list.removeFirst());
                }
            }
            else {
                for(int i = 0; i < -moveNum; i++) {
                    list.addFirst(list.removeLast());
                }
            }

            Balloon balloon = list.poll();
            moveNum = balloon.data;
            sb.append(balloon.index).append(" ");
        }

        System.out.println(sb);
    }
}
class Balloon {
    int index;
    int data;

    public Balloon(int index, int data) {
        this.index = index;
        this.data = data;
    }
}