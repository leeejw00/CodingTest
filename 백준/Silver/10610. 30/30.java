import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();

        char[] nums = str.toCharArray();
        Arrays.sort(nums);

        // 맨 끝 원소부터 0번까지 탐색
        
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (sum % 3 != 0 || nums[0] != '0') { // 30의 배수가 아니라면
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}