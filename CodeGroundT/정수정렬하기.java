import java.util.Arrays;
import java.util.Scanner;

class Solution {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt(); 
			}			
			Arrays.sort(arr);
			
			int answer = arr[0];
			for(int i = 1; i < n; i++) {
				if(i % 2 == 1) answer -= arr[i];
				else answer += arr[i];
			}	
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}
}