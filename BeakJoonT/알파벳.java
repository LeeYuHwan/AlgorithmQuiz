import java.util.ArrayList;
import java.util.Scanner;
class DFS{
	char[][] g;
	ArrayList<Character> check = new ArrayList<>();
	int maxH = 0;
	int maxW = 0;
	int answer = 0;
	public DFS(char[][] g, int maxH, int maxW) {
		this.g = g;
		this.maxH = maxH;
		this.maxW = maxW;
	}
	public int getResult(int h, int w) {
		dfs(h, w, 0, check);
		
		return answer;
	}
	int[] move_w = { 0, 0, -1, 1};
	int[] move_h = { -1, 1, 0, 0};

	void dfs(int h, int w, int cnt, ArrayList<Character> check) {
		check.add(g[h][w]);
		cnt++;
		
		for (int i = 0; i < 4; i++) {
			int tmp_w = w + move_w[i];
			int tmp_h = h + move_h[i];
			if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < maxW && tmp_h < maxH) {
				
				if (!check.contains(g[tmp_h][tmp_w])) {
					dfs(tmp_h, tmp_w, cnt, check);
					check.remove(check.size() - 1);
				}
				
			}
		}
		
		if(cnt > answer) answer = cnt;
	}
}

public class 알파벳 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		char[][] g = new char[r][c];
		for(int i = 0; i < r; i++) {
			String tmp = "";
			tmp = sc.next();
			for(int j = 0; j < tmp.length(); j++) {				
				g[i][j] = tmp.charAt(j);
			}
		}
		
		DFS Dfs = new DFS(g, r, c);
		int answer = Dfs.getResult(0, 0);
		
		System.out.println(answer);
	}
}