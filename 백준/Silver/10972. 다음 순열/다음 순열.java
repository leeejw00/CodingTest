import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextperm()) {
			for(int i=0; i<N; i++) {
				System.out.print(arr[i] + " ");
			}
		}else {
			System.out.println(-1);
		}
	}

	static boolean nextperm() {
		// 1. 뒤에서부터 봐주며  arr 오름차순 끝나는 지점 찾기
		int i = arr.length - 1;
		while(i > 0 && arr[i-1] > arr[i]) i--;
		
		if(i == 0) return false; //이미 arr이 내림차순 -> 다음 순열 없음
		
		// 2. i구간부터 끝까지 뒤에서부터 봐주기 (i-1과 swap할 j찾기)
		int j = arr.length - 1;
		while(j >= i && arr[i-1] > arr[j]) j--;
		
		// 3. i-1과 j swqp
		swap(i-1, j);
		
		// 4. i부터 끝까지 내림차순형태이니 뒤집어서 오름차순으로 만들어주기
		j = arr.length - 1;
		while(i < j) {
			swap(i,j);
			i++; j--;
		}
		
		//2~4까지 했다면 다음 순열 생성 완료
		return true;
	}

	static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}