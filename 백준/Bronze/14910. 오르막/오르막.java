import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		String ans = "Good";
		for(int i=1; i<list.size(); i++) {
			if(list.get(i-1) > list.get(i)) {
				ans = "Bad";
				break;
			}
		}
		System.out.println(ans);
	}
}