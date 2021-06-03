import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
 
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class 단지번호붙이기 {
	static int n = 0;
	static int ansIdx = 0;
	static int[] answer = new int[314];
	static int[][] arr = new int[26][26];
	static int[] move_h = { -1, 1, 0, 0};
	static int[] move_w = { 0, 0, -1, 1};
	static boolean[][] visit = new boolean[26][26];
	
	static void bfs(int startH, int startW) {
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.offer(new Pair(startH, startW));
		
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int h = p.first;
			int w = p.second;

			for (int i = 0; i < 4; i++) {
				int tmp_w = w + move_w[i];
				int tmp_h = h + move_h[i];
				if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < n && tmp_h < n) {
					if (arr[tmp_h][tmp_w] == 1 && visit[tmp_h][tmp_w] == false) {
						visit[tmp_h][tmp_w] = true;
						answer[ansIdx]++;
						q.offer(new Pair(tmp_h, tmp_w));
					}
				}
			}
		}
		
		ansIdx++;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String p = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = p.charAt(j) - 48;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && visit[i][j] == false) {
					visit[i][j] = true;
					answer[ansIdx]++;
					bfs(i, j);
				}
			}
		}
		
		Arrays.sort(answer);
		System.out.println(ansIdx);
		for(int i = 0; i < answer.length; i++) {
			if(answer[i] > 0) System.out.println(answer[i]);		
		}
	}
}