import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_폭발 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String bomb = br.readLine();	
		StringBuffer answer = new StringBuffer("");
		for(int i = 0; i < str.length(); i++) {
			answer.append(str.charAt(i));
			if(str.charAt(i) == bomb.charAt(bomb.length() - 1) && answer.length() >= bomb.length()) {
				boolean sw = true;
				for(int j = 0; j < bomb.length(); j++) {
					if(answer.charAt(answer.length() - bomb.length() + j) != bomb.charAt(j)) {
						sw = false;
						break;
					}
				}
				if(sw == true) {
					answer.delete(answer.length() - bomb.length(), answer.length());
				}
			}
			
		}
		if(answer.length() == 0) System.out.println("FRULA");
		else System.out.println(answer.toString());	
	}
}