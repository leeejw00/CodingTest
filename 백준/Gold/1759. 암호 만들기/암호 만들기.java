import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String[] arr;
	static String[] sel;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		arr = new String[C];
		sel = new String[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr);
		
		comb(0,0);
		System.out.println(sb);
		
	}

	static void comb(int idx, int sidx) {
		if(sidx == L) {
			if(check(sel)) {
				for(int i=0; i<L; i++) {
					sb.append(sel[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=idx; i<C; i++) {
			sel[sidx] = arr[i];
			comb(i+1, sidx+1);
		}
	}

	static boolean check(String[] sel) {
		int cnt1 = 0; //모음 개수
		int cnt2 = 0; //자음 개수
		
		for(int i=0; i<L; i++) {
			if(sel[i].equals("a") || sel[i].equals("e") || sel[i].equals("i") || sel[i].equals("o") || sel[i].equals("u"))
				cnt1++;
			else
				cnt2++;
		}
		if(cnt1 >= 1 && cnt2 >=2)
			return true;
		else
			return false;
	}

}