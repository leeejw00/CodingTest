import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int num2 = Integer.parseInt(st.nextToken());
			if(set.contains(num2))
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}
		
		System.out.println(sb);
	}
}