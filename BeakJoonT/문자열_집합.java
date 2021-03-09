import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class 문자열_집합 {
	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<>();
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		ArrayList<String> al = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String tmp = scanner.next();
			al.add(tmp);
		}
		
		for(int i = 0; i < m; i++) {
			String tmp = scanner.next();
			if(map.get(tmp) == null) map.put(tmp, 1);
			else {
				map.put(tmp, map.get(tmp) + 1);
			}
		}
		
		int answer = 0;
		for(int i = 0; i < al.size(); i++) {
			if(map.get(al.get(i)) != null) answer += map.get(al.get(i));
		}
		
		System.out.println(answer);
	}
}
