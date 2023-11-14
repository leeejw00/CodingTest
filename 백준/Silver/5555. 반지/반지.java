import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String ring = br.readLine();
			ring += ring; //마지막과 처음 이어서 text 되는 경우 (원형)
			
			if(ring.contains(text)) 
				cnt++;
		}
		System.out.println(cnt);
	}
}
//문자열 + 문자열
//문자열 .contains()