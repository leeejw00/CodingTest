import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
				
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String cloth = st.nextToken(); //옷 종류
                
				if(map.containsKey(cloth))
					map.put(cloth, map.get(cloth) + 1);
				else
					map.put(cloth, 1);
			}
			
//			for(String i : map.keySet()) {
//				System.out.println(i + " " + map.get(i));
//			}
			
			int ans = 1;
			for(Integer value : map.values()) {
				ans *= (value+1);
			}
			
			ans -= 1; //공집합(옷x) 빼기  
			System.out.println(ans);
		}
	}
}