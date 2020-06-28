package CodingDojang;
import java.util.Scanner;
public class CommaQuiz {
	public static boolean check(int size) {
		int tmp = size - 4;
		if(tmp % 3 == 0) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sw = 0, sw2 = 0, start = 0, size = 0, j = 0;
		String ans = scanner.nextLine();
		StringBuffer result = new StringBuffer(ans);
		
		if(ans.indexOf(".") > 0) size = ans.indexOf(".");
		else size = ans.length();
		
		if(ans.indexOf("-") == 0) {
			start = 1;
			size--;
		}
		
		if((size % 3) != 0) sw = -1;
		if(size == 4 || check(size) == true) {
			sw = -2; sw2 = 1;
		}
		for(int i = start; i < size;i++) {	
			if(j == 3) {
				result.insert(i + sw, ",");
				sw++;
				j = 0;
		    }
			j++;
			if(j == 2 && i == (size - 2)) {
				j++;
				sw++;
			}
		}	
		System.out.println(result);
	}
}

