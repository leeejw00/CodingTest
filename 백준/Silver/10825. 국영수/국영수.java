import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students[i] = new Student(name, korean, english, math);
        }

        // 국어 내림차순, 영어 오름차순, 수학 내림차순, 이름 오름차순
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.korean == s2.korean) {
                    if(s1.english == s2.english) {
                        if(s1.math == s2.math) {
                            return s1.name.compareTo(s2.name); // 문자열 비교 : compareTo()
                        }
                        return s2.math - s1.math;
                    }
                    return s1.english - s2.english;
                }
                return s2.korean - s1.korean;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(students[i].name).append("\n");
        }

        System.out.println(sb);
    }

    public static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}