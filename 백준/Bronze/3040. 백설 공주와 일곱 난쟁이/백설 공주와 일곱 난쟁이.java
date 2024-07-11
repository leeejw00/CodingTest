import java.util.Scanner;

public class Main {
    static int[] nums;
    static int[] result;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nums = new int[9];
        result = new int[7];
        isSelected = new boolean[9];

        for(int i = 0; i < 9; i++) {
            nums[i] = sc.nextInt();
        }

        comb(0, 0);
        System.out.println(sb);
    }

    private static void comb(int cnt, int idx) {
        if(cnt == 7) {
            int ans = 100;
            int sum = 0;
            for(int i = 0; i < 7; i++) {
                sum += result[i];
            }

            if(sum == ans) {
                for(int i = 0; i < 7; i++) {
                    sb.append(result[i]).append('\n');
                }
            }
            return;
        }

        for(int i = idx; i < 9; i++) {
            result[cnt] = nums[i];
            comb(cnt+1, i+1);
        }
    }
}