import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
	static int N = 0;
	static int[] board;
	static int answer = 0;
	
	static void dfs(int idx) {
		if(idx == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			board[idx] = i;
			if(check(idx)) dfs(idx + 1);
		}
	}
	
	static boolean check(int w) {
		for(int i = 0; i < w; i++) {
			if(board[w] == board[i]) return false;
			else if(Math.abs(w - i) == Math.abs(board[w] - board[i])) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		dfs(0);
		System.out.println(answer);
	}
}