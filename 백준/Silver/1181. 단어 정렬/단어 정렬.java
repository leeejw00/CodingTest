import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // set에 입력 받아 중복 단어 제거
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 배열로 옮기기
        String[] arr = new String[set.size()];
        int idx = 0;
        for (String str : set) {
            arr[idx++] = str;
        }

        // 정렬
        Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2); // 사전 순 정렬
            } 
            else {
                return s1.length() - s2.length(); // 길이 오름차순 정렬
            }
        });

        for (String str : arr) {
            System.out.println(str);
        }
    }
}