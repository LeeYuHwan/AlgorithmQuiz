import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇_청소기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int startH = Integer.parseInt(st.nextToken());
		int startW = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n + 1][m + 1];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		board[startH][startW] = 2;
		int answer = 1;
		
		int h = startH;
		int w = startW;
		
		int cnt = 0;
		while(true) {
			if(cnt == 4) {
				if(d == 0) {
					if(h + 1 < n && (board[h + 1][w] == 2 || board[h + 1][w] == 0)) {
						if(board[h + 1][w] == 0) {
							board[++h][w] = 2;
							answer++;
						}
						else ++h;
					}
					else break;
				}
				else if(d == 1) {
					if(w - 1 >= 0 && (board[h][w - 1] == 2 || board[h][w - 1] == 0)) {
						if(board[h][w - 1] == 0) {
							board[h][--w] = 2;
							answer++;
						}	
						else --w;
					}
					else break;
				}
				else if(d == 2) {
					if(h - 1 >= 0 && (board[h - 1][w] == 2 || board[h - 1][w] == 0)) {
						if(board[h - 1][w] == 0) {
							board[--h][w] = 2;
							answer++;
						}	
						else --h;
					}
					else break;
				}
				else {
					if(w + 1 < m && (board[h][w + 1] == 2 || board[h][w + 1] == 0)) {
						if(board[h][w + 1] == 0) {
							board[h][++w] = 2;
							answer++;
						}	
						else ++w;
					}
					else break;
				}
				cnt = 0;
			}
			else {
				if(d == 0) {
					if(w - 1 >= 0 && board[h][w - 1] == 0) {
						board[h][--w] = 2;
						answer++;
						cnt = 0;
					}
					else cnt++;
					d = 3;
				}
				else if(d == 1) {
					if(h - 1 >= 0 && board[h - 1][w] == 0) {
						board[--h][w] = 2;
						answer++;
						cnt = 0;
					}
					else cnt++;
					d = 0;
				}
				else if(d == 2) {
					if(w + 1 < m && board[h][w + 1] == 0) {
						board[h][++w] = 2;
						answer++;
						cnt = 0;
					}
					else cnt++;
					d = 1;
				}
				else {
					if(h + 1 < n && board[h + 1][w] == 0) {
						board[++h][w] = 2;
						answer++;
						cnt = 0;
					}
					else cnt++;
					d = 2;
				}
			}					
		}
		
		System.out.println(answer);
	}
}