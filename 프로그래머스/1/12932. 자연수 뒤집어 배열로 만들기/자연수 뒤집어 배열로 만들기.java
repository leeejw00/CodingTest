class Solution {
    public int[] solution(long n) {
        // 숫자 -> 문자열 변환
        String str = Long.toString(n);

        // 문자 하나하나 다시 숫자로 변환 후 배열 마지막 위치부터 거꾸로 입력
        int[] answer = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            answer[str.length() - 1 - i] = num;
        }
        
        return answer;
    }
}