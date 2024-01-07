public class Main {
    public static void main(String[] args) {

        boolean[] check = new boolean[10001];

        for(int i=1; i<=10000; i++) {
            int num = d(i);
            if(num < 10001) check[num] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++) {
            if(!check[i]) sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    static int d(int num) {
        int sum = num;

        while(num != 0) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }
}