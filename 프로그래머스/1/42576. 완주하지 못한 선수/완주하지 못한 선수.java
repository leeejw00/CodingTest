import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String player : participant) {
            hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
            // getOrDefault()로 중복 이름 선수 확인하여 있으면 +1, 없으면 0 입력
        }

        for (String player : completion) {
            hashMap.put(player, hashMap.get(player) - 1);
        }

        for (String player : hashMap.keySet()) {
            if (hashMap.get(player) != 0) {
                answer = player;
                break;
            }
        }
        
        return answer;
    }
}