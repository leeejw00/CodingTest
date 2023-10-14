import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[] parent;
	static int[] rank; //트리 높이 저장
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		
		parent = new int[n+1]; 
		rank = new int[n+1];
		
		//make-set
		for(int i=0; i<n+1; i++) {
			parent[i] = i;
			rank[i] = i;   
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); //0 또는 1
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(num==0) {
				union(A,B);
			}else {
				if(find(A)==find(B)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}	
		
	}//main

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		
		if(rank[a] > rank[b])
			parent[b] = a;
		else {
			parent[a] = b;
			
			if(rank[a] == rank[b]) ++rank[a];
		}
	}
	
	static int find(int x) {
		if(x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
}