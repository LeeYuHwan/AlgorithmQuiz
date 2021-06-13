import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
	static int k = 0;
	static int[] arr;
	static boolean[] visit;
	
	static void dfs(int start, int cnt) {
		if(cnt == 6) {
			for(int i = 0; i < k; i++) {
				if(visit[i]) System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
		for(int i = start; i < k; i++) {
			visit[i] = true;
			dfs(i + 1, cnt + 1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			arr = new int[k];
			visit = new boolean[k];
			for(int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			System.out.println();
		}	
	}
}