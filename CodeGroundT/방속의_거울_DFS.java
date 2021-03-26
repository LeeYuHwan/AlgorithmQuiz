import java.util.Scanner;

class DFS2{
	char[][] g;
	int[][] check;
	int maxH = 0;
	int maxW = 0;
	int answer = 0;
	public DFS2(char[][] g, int maxH, int maxW) {
		this.g = g;
		this.maxH = maxH;
		this.maxW = maxW;
		check = new int[maxH][maxW];
	}
	public int getResult(int h, int w) {
		check[h][w] = 1;
		if(g[h][w] == '2') {
			answer++;
			dfs(h, w, h + 1, w);
		}
		else if(g[h][w] == '1') return 1;
		else dfs(h, w, h, w + 1);		
		return answer;
	}

	void dfs(int preH, int preW, int h, int w) {
		if (!(h >= 0 && w >= 0 && w < maxW && h < maxH)) {
			return;
		}		
						
		if(g[h][w] == '2') {
			if(check[h][w] != 1) answer++;
			check[h][w] = 1;
			if(preH == h && preW < w) { // 왼쪽에서 들어옴
				dfs(h, w, h + 1, w);
			}
			else if(preH == h && preW > w) { // 오른쪽에서 들어옴
				dfs(h, w, h - 1, w);
			}
			else if(preH < h && preW == w) { // 위에서 들어옴
				dfs(h, w, h, w + 1);
			}
			else if(preH > h && preW == w) {// 아래에서 들어옴
				dfs(h, w, h, w - 1);
			}
			
		}
		else if(g[h][w] == '1') {
			if(check[h][w] != 1) answer++;
			check[h][w] = 1;
			if(preH == h && preW < w) { // 왼쪽에서 들어옴
				dfs(h, w, h - 1, w);
			}
			else if(preH == h && preW > w) { // 오른쪽에서 들어옴
				dfs(h, w, h + 1, w);
			}
			else if(preH < h && preW == w) { // 위에서 들어옴
				dfs(h, w, h, w - 1);
			}
			else if(preH > h && preW == w) {// 아래에서 들어옴
				dfs(h, w, h, w + 1);
			}
		}
		else {
			check[h][w] = 1;
			if(preH == h && preW < w) { // 왼쪽에서 들어옴
				dfs(h, w, h, w + 1);
			}
			else if(preH == h && preW > w) { // 오른쪽에서 들어옴
				dfs(h, w, h, w - 1);
			}
			else if(preH < h && preW == w) { // 위에서 들어옴
				dfs(h, w, h + 1, w);
			}
			else if(preH > h && preW == w) {// 아래에서 들어옴
				dfs(h, w, h - 1, w);
			}
		}
	}
}
public class 방속의_거울_DFS {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			
			char[][] room = new char[N][N];
			
			for(int i = 0 ; i < N; i++) {
				String tmp = sc.next();
				
				for(int j = 0; j < N; j++) {
					room[i][j] = tmp.charAt(j);
				}
			}
			
			DFS2 dfsClass = new DFS2(room, N, N);
			int answer = dfsClass.getResult(0, 0);
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}
}