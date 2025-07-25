import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        HashMap<Character, Boolean> map;
        int ans = N;

        for (String str : arr) {
            map = new HashMap<>();

            // 단어의 첫 글자 map에 넣어주기
            char beforeWord = str.charAt(0);
            map.put(beforeWord, true);

            // 다음 글자부터 이전 글자와 비교하며 확인
            for (int i = 1; i < str.length(); i++) {

                // 현재 글자가 map에 없다면 안나왔던 단어이므로 map에 넣어주기
                if (!map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), true);
                    beforeWord = str.charAt(i);
                }

                // 현재 글자가 map에 있고 바로 전 글자와 다르다면 그룹단어 x
                else if (str.charAt(i) != beforeWord){
                    ans--;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}