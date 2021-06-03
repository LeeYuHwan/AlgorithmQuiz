import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class 생태학 {
	public static void main(String[] args) throws IOException {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		while(true) {
			String p = br.readLine();	
            
			if(p == null || p.equals("")) break;
			
			tm.put(p, tm.getOrDefault(p, 0) + 1);
			sum++;			
		}
		
		for(String i : tm.keySet()){ //저장된 key값 확인
			double percent = (double)(tm.get(i) * 100) / sum;
			System.out.println(i + " " + String.format("%.4f", percent));
		}
	}
}