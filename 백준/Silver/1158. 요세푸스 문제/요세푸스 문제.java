import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int index = 0; // 현재 가리키는 원소 위치 (이 위치에서 시작하여 K번째 사람 찾기)
        while (!list.isEmpty()) {

            // list의 범위 벗어나면 처음으로 돌아가게끔 하기 (원형 효과)
            index = (index + K - 1) % list.size();

            // 마지막 원소 제거하는 경우 쉼표 x
            if(list.size() == 1) {
                sb.append(list.remove(index));
            } else{
                sb.append(list.remove(index)).append(", ");
            }
        }

        sb.append('>');
        System.out.println(sb);
    }
}