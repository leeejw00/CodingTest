import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] leftStart = new int[n+1]; // 왼쪽부터 증가수열
        int[] rightStart = new int[n+1]; // 오른쪽부터 증가수열

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽부터 증가수열
        for(int i = 1; i <= n; i++) {
            leftStart[i] = 1;
            for(int j = 1; j < i; j++) {
                if(arr[i] > arr[j] && leftStart[i] <= leftStart[j]) {
                    leftStart[i] = leftStart[j] + 1;
                }
            }
        }

        // 오른쪽부터 증가수열
        for(int i = n; i >= 1; i--) {
            rightStart[i] = 1;
            for(int j = n; j > i; j--) {
                if(arr[i] > arr[j] && rightStart[i] <= rightStart[j]) {
                    rightStart[i] = rightStart[j] + 1;
                }
            }
        }

        // 두 수열의 합 중 가장 큰 값 구하기
        int max = -1;
        for(int i = 1; i <= n; i++) {
            int sum = leftStart[i] + rightStart[i];
            max = Math.max(max, sum);
        }

        System.out.println(max - 1); //중복된 인덱스 값 빼기
    }
}