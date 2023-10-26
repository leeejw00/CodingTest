import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] pibo = new int[46];
		
		pibo[0] = 0;
		pibo[1] = 1;
		for(int i=2; i<pibo.length; i++) {
			pibo[i] = pibo[i-1] + pibo[i-2];
		}
		
		System.out.println(pibo[n]);
		
	}
}