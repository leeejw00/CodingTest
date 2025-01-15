import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);


        // 최소 거리를 찾는 이분탐색
        int min = 1; // 집 사이 거리 최소 거리 => 1
        int max = house[N-1] - house[0] + 1; // 첫 집과 마지막 집 사이 거리가 최댓값

        int mid = 0;

        // Upper Bound
        while (min < max) {

            mid  = (min + max) / 2;

            /*
            * mid 거리에 대해 설치 가능한 공유기 개수가 M 보다 작으면
            * 거리 좁혀야 함
            * */
            if (canInstall(mid) < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        /*
        * Upper Bound는 탐색 값을 초과하는 첫 번째 값
        * -> 1을 빼준 값이 조건식을 만족하는 최댓값
        * */
        System.out.println(min - 1);
    }

    // 거리에 대해 설치 가능한 공유기 개수 찾기
    static int canInstall (int dis) {

        int cnt = 1; // 첫번째 집은 무조건 설치
        int lastLocate = house[0]; // 마지막 공유기 설치 위치

        for (int i = 1; i < house.length; i++) {
            int locate = house[i]; // 현재 집의 위치

            /*
            * 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
            * 최소 거리보다 크거나 같으면 공유기 설치 개수 늘려주고
            * 마지막 설치 위치 갱신
            * */
            if (locate - lastLocate >= dis) {
                cnt++;
                lastLocate = locate;
            }
        }

        return cnt;
    }
}
/**
 * 최소 거리에 대해 설치 가능한 공유기가
 * 설치 해야할 공유기의 개수와 같은 거리 중
 * 최소거리가 가장 큰 값
 */

/**
 * 거리를 탐색 범위로 잡고 이분탐색
 * 해당 거리에 대해 설치 가능한 공유기의 개수에 따라
 * 탐색하는 거리의 범위 좁혀나가기
 */

/**
 * 최대로 가질 수 있는 최소거리를 찾아야 하므로
 * Upper Bound 형식 따르기
 */