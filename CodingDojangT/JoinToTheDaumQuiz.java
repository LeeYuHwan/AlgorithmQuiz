package CodingDojang;
import java.util.Vector;

public class JoinToTheDaumQuiz {
	public static void main(String[] args) {
		Vector<Integer> result = new Vector<Integer>();
		int[] s = {1, 3, 4, 12, 13, 14, 20};
		int min = s[s.length - 1];
		
		for(int i = 0; i < s.length - 1; i++) {
			if(min >= s[i + 1] - s[i]) {
				min = s[i + 1] - s[i];
				result.add(s[i]);
				result.add(s[i + 1]);
			}			
		}
		
		for(int i = 0 ; i < result.size() - 1; i++) {
			int n = result.get(i + 1) - result.get(i);
			if(n == min) {
				int p = result.get(i);
				int p2 = result.get(i+1);
				System.out.println(p+","+p2);
			}
		}
	}
}
