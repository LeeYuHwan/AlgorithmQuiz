package CodingDojang;
import java.util.Scanner;

public class CaesarPassQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String ans = scanner.nextLine();
		int n = scanner.nextInt();
		
		String result = "";
		
		for(int i = 0; i < ans.length(); i++) {
			if(ans.charAt(i) == ' ') result += ans.charAt(i);
			else {
                int tmp = 0;
                int count = 0;
				int check = ans.charAt(i);
				if(check >= 65 && check <= 90) {
					tmp = (ans.charAt(i) + n);
					count = (ans.charAt(i) + n) % 90;
					if(tmp > 90) tmp = 64 + count;
				}							
				else if(check >= 97 && check <= 122){
					tmp = (ans.charAt(i) + n);
					count = (ans.charAt(i) + n) % 122;
					if(tmp > 122) tmp = 96 + count;
				}
				result += (char)tmp;
			}						
		}
		System.out.println(result);
	}
}
