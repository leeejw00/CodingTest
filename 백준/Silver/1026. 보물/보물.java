import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer a = new StringTokenizer(br.readLine());
		StringTokenizer b = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(a.nextToken());
			B[i] = Integer.parseInt(b.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += (A[i]*B[N-1-i]);
		}
		
		System.out.println(sum);
	}
}