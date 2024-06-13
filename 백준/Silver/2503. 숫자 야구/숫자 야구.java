import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 답이 될 수 있는 정수 boolean 배열 123~987 만들기
        boolean[] arr = new boolean[988];
        for(int i=123; i<988; i++) {
            arr[i] = true; // true로 초기화

            String numToString = String.valueOf(i);
            // 0이 들어가는 경우 false로 변경
            if (numToString.charAt(0) == '0' || numToString.charAt(1) == '0' || numToString.charAt(2) == '0') {
                arr[i] = false;
            }

            // 중복되는 숫자가 있는 경우 false로 변경
            if(numToString.charAt(0) == numToString.charAt(1) || numToString.charAt(0) == numToString.charAt(2) ||
                    numToString.charAt(1) == numToString.charAt(2)) {
                arr[i] = false;
            }
        }

        // 2. 질문 수 만큼 strike, ball 숫자 비교
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for(int j=123; j<988; j++) {
                String myNum = String.valueOf(j);
                String inputNum = String.valueOf(num);

                int tempStrike = 0;
                int tempBall = 0;
                for(int a=0; a<3; a++) {
                    for(int b=0; b<3; b++) {
                        if(a == b && myNum.charAt(a) == inputNum.charAt(b))
                            tempStrike++;

                        if(a != b && myNum.charAt(a) == inputNum.charAt(b))
                            tempBall++;
                    }
                }

                // 정답이 될 확률이 없는 수라면 false로 변경
                if((tempStrike != strike) || (tempBall != ball)) {
                    arr[j] = false;
                }
            }
        }

        int ans = 0;
        for(int i=123; i<988; i++) {
            if(arr[i]) ans++;
        }

        System.out.println(ans);
    }
}