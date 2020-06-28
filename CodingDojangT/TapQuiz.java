package CodingDojang;
import java.util.Scanner;

public class TapQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String ans = "테스트1\t테스트2\t테스트3";
		
		System.out.println("변환 전 =>" + ans);
		ans = ans.replace("\t", " ");
		System.out.println("변환 후 =>" + ans);
	}
}
