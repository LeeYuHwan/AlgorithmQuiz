import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 통나무_건너뛰기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
				
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());				
			}	
			
			Arrays.sort(arr);
			
			int[] ansArr = new int[N];
			int first = 0, last = N - 1;
			for(int i = 0; i < N; i++) {
				if(i % 2 == 0) ansArr[first++] = arr[i];
				else ansArr[last--] = arr[i];
			}
			
			int answer = 0;
			for(int i = 1; i < N; i++) {
				if(answer < Math.abs(ansArr[i - 1] - ansArr[i])) answer = Math.abs(ansArr[i - 1] - ansArr[i]);
			}
			
			System.out.println(answer);
		}
	}
}