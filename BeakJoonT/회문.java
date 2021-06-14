import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			
			boolean sw = true;
			boolean sw2 = false;
			for(int i = 0; i < (str.length() + 1 )/ 2; i++) {
				
				if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					sw = false;
					if(str.charAt(i + 1) == str.charAt(str.length() - 1 - i)) {
						sw2 = true;
						for(int j = i; j < (str.length() + 1) / 2; j++) {
							if(str.charAt(j + 1) != str.charAt(str.length() - 1 - j)) {
								sw2 = false;
								break;
							}
						}
						if(sw2) break;
					}
					if(str.charAt(i) == str.charAt(str.length() - 2 - i)) {	
						sw2 = true;
						for(int j = i; j < (str.length() + 1) / 2; j++) {
							if(str.charAt(j) != str.charAt(str.length() - 2 - j)) {				
								sw2 = false;
								break;
							}
						}
						if(sw2) break;
					}
					else {
						break;
					}
					
					if(!sw2) break;
				}
			}
			if(sw) System.out.println(0);
			else {
				if(sw2) {
					System.out.println(1);
				}
				else System.out.println(2);
			}
		}
	}
}