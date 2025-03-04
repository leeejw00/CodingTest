class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // yellow의 약수 완전탐색
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            
            int tempYellowWidth = yellow / i;
            int tempYellowLength = i;
            
            int tempBrownCnt = (tempYellowWidth * 2) + (tempYellowLength * 2) + 4;
            if (tempBrownCnt == brown) {
                answer[0] = tempYellowWidth + 2;
                answer[1] = tempYellowLength + 2;
                break;
            }
        }
        
        return answer;
    }
}