import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 재생 횟수 저장
        HashMap<String, Integer> num = new HashMap<>();
        // 각 "장르"에 속한 노래의 "고유번호", "재생 횟수" 쌍 저장
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }

        // 총 장르 리스트에 저장 (정렬하기 위해)
        List<String> genreNames = new ArrayList<>(num.keySet());
        // 리스트를 재생 횟수에 따라 내림차순으로 정렬
        Collections.sort(genreNames, (s1, s2) -> num.get(s2) - num.get(s1));
        /*
            리스트를 재생 횟수에 따라 내림차순으로 정렬
            s1과 s2는 keySet에서 가져온 두 개의 장르명.
            num.get(s1)과 num.get(s2)는 각각 장르 s1과 s2의 총 재생 횟수를 num 해시맵에서 조회.
            num.get(s2) - num.get(s1)는 s2의 재생 횟수에서 s1의 재생 횟수를 빼는 것.

            결과가 양수라면 s2가 s1보다 더 많이 재생된 것이므로, s2를 s1보다 앞에 위치 (내림차순).
            결과가 음수라면 s1이 s2보다 더 많이 재생되어, s1을 s2보다 앞에 위치.
            결과가 0이면 두 장르의 재생 횟수가 같다는 의미 => 두 요소의 순서는 변경되지 않는다.
        */

        ArrayList<Integer> answer = new ArrayList<>(); // 답으로 제출할 배열에 넣어줄 리스트

        // 내림차순된 장르명 리스트 순회하며 각 장르별로 재생횟수 높은 순서대로 곡 정렬
        for (String genre : genreNames) {
            HashMap<Integer, Integer> map = music.get(genre);
            List<Integer> genreKey = new ArrayList<>(map.keySet()); // 해당 장르의 곡고유번호 리스트에 저장

            // keySet에 저장된 곡 고유번호를 통해 재생 횟수를 기준으로 내림차순 정렬
            Collections.sort(genreKey, (s1, s2) -> map.get(s2) - map.get(s1));

            // 각 장르에서 재생 횟수가 높은 순서대로 최대 두 곡을 answer 리스트에 추가
            answer.add(genreKey.get(0)); // -> 첫 번째 곡
            if (genreKey.size() > 1) answer.add(genreKey.get(1)); // -> 두 번째 곡
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}