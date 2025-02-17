import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        boolean answer = true;

        out : for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                // 해당 전화번호의 길이만큼 반복해서 확인
                // 접두어 부분문자열로 가지고 있는 key 있는지 확인
                String headString = phone_book[i].substring(0, j);
                if (map.containsKey(headString)) {
                    answer = false;
                    break out;
                }
            }
        }

        return answer;
    }
}