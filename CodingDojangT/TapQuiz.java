package CodingDojang;
import java.util.Scanner;

public class TapQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String ans = "�׽�Ʈ1\t�׽�Ʈ2\t�׽�Ʈ3";
		
		System.out.println("��ȯ �� =>" + ans);
		ans = ans.replace("\t", " ");
		System.out.println("��ȯ �� =>" + ans);
	}
}
