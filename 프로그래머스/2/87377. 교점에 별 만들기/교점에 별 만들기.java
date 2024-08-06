import java.util.*;

class Solution {
    // 1. 좌표 클래스 생성
    private static class Point {
        public long x,y;
        
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 2. 교차점 구하는 메서드
    public static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1*c2 - c1*b2) / (a1*b2 - b1*a2);
        double y = (double) (c1*a2 - a1*c2) / (a1*b2 - b1*a2);

        if((x % 1 != 0) || (y % 1 != 0)) return null; // 정수가 아닐 경우
        return new Point((long)x, (long)y); // 정수일 경우
    }

    // line : 직선 A,B,C에 대한 정보가 담긴 배열
    public String[] solution(int[][] line) {

        // 3. Point 타입의 pointList에 정수 교차점 모두 저장
        List<Point> pointList = new ArrayList<>();

        for(int i = 0; i < line.length; i++) {
            for(int j = i+1; j < line.length; j++) {
                Point intersection = intersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);

                if(intersection != null) pointList.add(intersection);
            }
        }

        // 4. 교차점 x,y 최대 최소 탐색 후 갱신
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for(int i = 0; i < pointList.size(); i++) {
            maxX = Math.max(maxX, pointList.get(i).x);
            maxY = Math.max(maxY, pointList.get(i).y);
            minX = Math.min(minX, pointList.get(i).x);
            minY = Math.min(minY, pointList.get(i).y);
        }

        // 5. 최소사각형 크기 구한 후 배열 채우기
        int xLength = (int)(maxX - minX + 1);
        int yLength = (int)(maxY - minY + 1);

        char[][] map = new char[yLength][xLength]; // **배열은 행렬순이므로 y,x

        for(int i = 0; i < yLength; i++) {
            for(int j = 0; j < xLength; j++) {
                map[i][j] = '.';
            }
        }

        for(int i = 0; i < pointList.size(); i++) {
            int x = (int)(pointList.get(i).x - minX);
            int y = (int)(maxY - pointList.get(i).y); // y축은 이차원배열로 나타낼시 함수와 반대방향

            map[y][x] = '*';
        }


        String[] answer = new String[map.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}