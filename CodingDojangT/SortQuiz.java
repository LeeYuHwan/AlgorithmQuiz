package CodingDojang;
import java.util.Scanner;

public class SortQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int ans[] = {-1, 1, 3, -2, 2};
		int sw = 0;
		int count = 0;
		int temp = 0;
		
		for(int i = 0; i < ans.length; i++) {
			for(int j = 0; j < ans.length - i; j++) {
				if(ans[i] > 0 && ans[i+j] < 0) {
					temp = ans[i];
					ans[i] = ans[i + j];
					ans[i + j] = temp;
					
					sw = 1;
					count = (i + j) - i;
				}				
			}
			if(sw == 1) {
				for(int j = i + 1; j < ans.length - count; j++) {
					temp = ans[j];
					ans[j] = ans[j + 1];
					ans[j + 1] = temp;
				}
				sw = 0;
			}
		}
		for(int i = 0; i < ans.length; i++) 
			System.out.print(ans[i]);
	}
}
