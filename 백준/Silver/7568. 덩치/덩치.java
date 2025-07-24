import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        int[] rank = new int[N];

        // 키, 몸무게 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 덩치 계산
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank[i]++;
                }
                else if (people[i][0] > people[j][0] && people[i][1] > people[j][1]) {
                    rank[j]++;
                }
            }
        }

        // 마지막에 정답 출력할 때 rank +1 씩 해주기
        for (int i = 0; i < N; i++) {
            System.out.print(rank[i] + 1);
            System.out.print(" ");
        }
    }
}