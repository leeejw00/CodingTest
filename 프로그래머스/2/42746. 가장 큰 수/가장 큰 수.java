import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 문자열 배열 생성 후 원소 넣어주기
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // compareTo()를 이용해 두 문자열을 합친 값 (o2+o1)과 (o1+o2) 중
        // 값이 큰 값을 기준으로 내림차순 정렬
        Arrays.sort(nums, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        // 만약 오름차순이라면
       // Arrays.sort(nums, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        
        // 입력 값이 [0, 0, 0] 일 경우 대비
        if (nums[0].equals("0")) return "0";

        // 내림차순 정렬된 문자열 배열 answer에 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (String str : nums) {
            sb.append(str);
        }

        return sb.toString();
    }
}