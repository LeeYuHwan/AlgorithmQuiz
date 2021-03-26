import java.util.Scanner;

class Solution {
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
			
			int[][] check = new int[N][N];
			
			int h = 0, w = 0;
			int preH = 0, preW = 0;
			boolean sw = false;
			int answer = 0;
			
			check[h][w] = 1;
			if(room[h][w] == '2') {
				answer++;	
				h += 1;
				sw = true;
			}
			else if(room[h][w] == '1') {
				answer = 1;
			}
			else {
				w += 1;
				sw = true;
			}
			
			if(sw == true) {
				while(h >= 0 && w >= 0 && w < N && h < N) {
					if(room[h][w] == '2') {
						if(check[h][w] != 1) answer++;
						check[h][w] = 1;
						if(preH == h && preW < w) { // 왼쪽에서 들어옴
							preH = h;
							preW = w;
							h++;
						}
						else if(preH == h && preW > w) { // 오른쪽에서 들어옴
							preH = h;
							preW = w;
							h--;
						}
						else if(preH < h && preW == w) { // 위에서 들어옴
							preH = h;
							preW = w;
							w++;
						}
						else if(preH > h && preW == w) {// 아래에서 들어옴
							preH = h;
							preW = w;
							w--;
						}
						
					}
					else if(room[h][w] == '1') {
						if(check[h][w] != 1) answer++;
						check[h][w] = 1;
						if(preH == h && preW < w) { // 왼쪽에서 들어옴
							preH = h;
							preW = w;
							h--;
						}
						else if(preH == h && preW > w) { // 오른쪽에서 들어옴
							preH = h;
							preW = w;
							h++;
						}
						else if(preH < h && preW == w) { // 위에서 들어옴
							preH = h;
							preW = w;
							w--;
						}
						else if(preH > h && preW == w) {// 아래에서 들어옴
							preH = h;
							preW = w;
							w++;
						}
					}
					else {
						check[h][w] = 1;
						if(preH == h && preW < w) { // 왼쪽에서 들어옴
							preH = h;
							preW = w;
							w++;
						}
						else if(preH == h && preW > w) { // 오른쪽에서 들어옴
							preH = h;
							preW = w;
							w--;
						}
						else if(preH < h && preW == w) { // 위에서 들어옴
							preH = h;
							preW = w;
							h++;
						}
						else if(preH > h && preW == w) {// 아래에서 들어옴
							preH = h;
							preW = w;
							h--;
						}
					}									
				}
			}
						
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}
}