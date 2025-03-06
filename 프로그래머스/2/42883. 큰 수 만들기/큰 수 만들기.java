class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int len = number.length() - k; // 새로 만들 수의 길이
        int idx = 0; // 수 비교 시작하는 인덱스

        // 만들어야 할 수 길이만큼 반복
        for (int i = 0; i < len; i++) {
            int max = 0;

            // 선택할 수 있는 범위 내에서 가장 큰 숫자 찾기
            for (int j = idx; j <= k+i; j++) { 
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }

            answer.append(max);
        }

        return answer.toString();
    }
}