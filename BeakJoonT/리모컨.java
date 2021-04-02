import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨 {
	static boolean[] btnX;
	static int check(int n) {
		if(n == 0) {
			if(btnX[0]) return 0;
			else return 1;
		}
		
		int tmp = 0;
		while(n > 0) {
			if(btnX[n % 10]) {
				return 0;
			}
			n /= 10;
			tmp += 1;
		}
		return tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		
		btnX = new boolean[10];
		
		if(M != 0) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for(int i = 0; i < M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				btnX[idx] = true;
			}
		}
				
		int count = Math.abs(N - 100);
		for(int i = 0; i <= 1000000; i++) {
			int tmp = check(i);
			if(tmp > 0) {
				int press = Math.abs(N - i);
				count = Math.min(count, tmp + press);
			}
		}
		
		System.out.println(count);
		reader.close();
	}
}