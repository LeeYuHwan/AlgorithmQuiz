import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class 추월 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> al = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringBuilder p = new StringBuilder(br.readLine());			
			hm.put(p.toString(), i);
		}
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			StringBuilder p = new StringBuilder(br.readLine());			
			int check = hm.get(p.toString());
			al.add(check);
			if(i > 0 && check < al.get(i - 1)) {
				for(int j = i - 1; j >= 0; j--) {
					if(al.get(j) > check) {
						answer++;
						al.set(j, -1);
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}