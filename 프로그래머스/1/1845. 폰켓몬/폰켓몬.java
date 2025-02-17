import java.util.*; 
    
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length / 2;

        HashSet<Integer> hashSet = new HashSet<>(); // 중복 제거
        for (int num : nums) {
            hashSet.add(num);
        }

        int size = hashSet.size();
        if (len <= size) {
            answer = len;
        } else {
            answer = size;
        }
        
        return answer;
    }
}