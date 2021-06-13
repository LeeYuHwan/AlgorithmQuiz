import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호_만들기 {
	static int L = 0, C = 0;
	static char[] arr;
	static boolean[] visit;
	
	static void dfs(int start, int cnt, int ja, int mo) {
		for(int i = start; i < C; i++) {
			visit[i] = true;
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') dfs(i + 1, cnt + 1, ja, mo + 1);     
	        else dfs(i + 1, cnt + 1, ja + 1, mo);	            
			
			visit[i] = false;
		}
		
		if(cnt == L && mo >= 1 && ja >= 2) {
			for(int i = 0; i < C; i++) {
				if(visit[i] == true) System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		visit = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		dfs(0, 0, 0, 0);
	}
}