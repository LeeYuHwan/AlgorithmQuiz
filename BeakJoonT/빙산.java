import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class DFS3{
	int[][] g;
	int[][] tmpG;
	int[][] check;
	int maxH = 0;
	int maxW = 0;
	int answer = 0;
	public DFS3(int[][] g, int maxH, int maxW) {
		this.g = g;
		this.maxH = maxH;
		this.maxW = maxW;
		this.check = new int[maxH][maxW];
	}
	public int getResult(int h, int w) {
		int count = 0;
		
		while(true) {
			count = 0;
			boolean sw = false;
			this.check = new int[maxH][maxW];
			tmpG = new int[maxH][maxW];
			for(int i = 0; i < maxH; i++) {
				for(int j = 0; j < maxW; j++) {
					tmpG[i][j] = g[i][j];			
				}
			}
			
			for(int i = 0; i < maxH; i++) {
				for(int j = 0; j < maxW; j++) {
					if(g[i][j] > 0 && check[i][j] != -1) {
						dfs(i, j, 0, check);
						sw = true;
						count++;
					}				
				}
			}

			for(int i = 0; i < maxH; i++) {
				for(int j = 0; j < maxW; j++) {
					 g[i][j] = tmpG[i][j];			
				}
			}
			
			if(count >= 2) break;
			
			if(sw == false) {
				answer = 0;
				break;
			}
			else {
				answer++;
			}	
		}
				
		return answer;
	}
	int[] move_w = { 0, 0, -1, 1};
	int[] move_h = { -1, 1, 0, 0};

	void dfs(int h, int w, int cnt, int[][] check) {
		if(g[h][w] > 0 && check[h][w] != -1) {
			check[h][w] = -1;
			for (int i = 0; i < 4; i++) {
				int tmp_w = w + move_w[i];
				int tmp_h = h + move_h[i];
				if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < maxW && tmp_h < maxH) {
					
					if(g[tmp_h][tmp_w] == 0 && tmpG[h][w] > 0) {
						tmpG[h][w]--;
					}
					
					if (g[h][w] > 0 && check[tmp_h][tmp_w] != -1) {
						dfs(tmp_h, tmp_w, cnt, check);
					}
					
				}
			}
		}		
	}
}

public class 빙산 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] g = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for(int j = 0; j < M; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS3 dfs3 = new DFS3(g, N, M);
		int answer = dfs3.getResult(0, 0);
		
		System.out.println(answer);
	}
}