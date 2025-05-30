class Solution {
    public int solution(String name) {
        int answer = 0; // 조이스틱 조작 횟수
        int len = name.length();
        int move = name.length() - 1; // 기본 최소 좌우이동 횟수

        // 알파벳 변경
        for (int i = 0; i < len; i++) {
            // 알파벳 조작 상하 중 최소 값으로 조작하기
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 'A' 가 끝나는 지점 찾기
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우이동 최소 횟수 구하기 (순서대로 가기 vs 뒤로 돌아가기)
            move = Math.min(move, (i*2) + (len - next));
            move = Math.min(move, ((len - next) * 2) + i);
        }
        answer += move;

        return answer;
    }
}