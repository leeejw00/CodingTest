import java.io.*;
import java.util.*;

public class Main {
    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    static int N, M, K;
    static int[][] A, map;
    static List<Tree> trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        trees = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }

        for (int year = 0; year < K; year++) {
            springAndSummer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    static void springAndSummer() {
        List<Tree> newTrees = new ArrayList<>();
        List<Tree> deadTrees = new ArrayList<>();

        Collections.sort(trees); // 나이 순 정렬

        for (Tree t : trees) {
            if (map[t.x][t.y] >= t.age) {
                map[t.x][t.y] -= t.age;
                t.age++;
                newTrees.add(t);
            } else {
                deadTrees.add(t);
            }
        }

        // 여름: 죽은 나무 처리
        for (Tree t : deadTrees) {
            map[t.x][t.y] += t.age / 2;
        }

        trees = newTrees; // 살아남은 나무만 유지
    }

    static void fall() {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        List<Tree> babyTrees = new ArrayList<>();

        for (Tree t : trees) {
            if (t.age % 5 != 0) continue;

            for (int d = 0; d < 8; d++) {
                int nx = t.x + dx[d];
                int ny = t.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                babyTrees.add(new Tree(nx, ny, 1));
            }
        }

        // 어린 나무 먼저 앞에 추가
        trees.addAll(0, babyTrees);
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }
}
