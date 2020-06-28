package CodingDojang;
import java.util.Arrays;
import java.util.Scanner;

public class MiddleNumberQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] ans = new int[3];
		for(int i = 0; i < ans.length; i++)
			ans[i] = scanner.nextInt();
		Arrays.sort(ans);
		System.out.println(ans[1]);
	}
}
