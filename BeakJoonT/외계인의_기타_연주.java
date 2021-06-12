import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 외계인의_기타_연주 {
	public static void main(String[] args) throws IOException {
		Stack<Integer>[] stk = new Stack[7];
		
		for(int i = 0; i < 7; i++) {
			stk[i] = new Stack<Integer>();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(stk[n].isEmpty()) {
				stk[n].push(p);
				answer++;
			}
			else {
				while(!stk[n].isEmpty()) {
					if(stk[n].peek() < p) {
						stk[n].push(p);
						answer++;
						break;
					}
					else if(stk[n].peek() == p){
						break;
					}
					else {
						stk[n].pop();
						answer++;
						if(stk[n].isEmpty()) {
							stk[n].push(p);
							answer++;
							break;
						}
					}
				}
			}
		}
				
		System.out.println(answer);
	}
}