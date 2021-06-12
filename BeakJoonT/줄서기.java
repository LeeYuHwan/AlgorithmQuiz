import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 줄서기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> arr = new ArrayList<>();
		List<String> check = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				String input = st.nextToken();
				arr.add(input);
				check.add(input);
			}
		}
		
		
		Collections.sort(check, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            if(s1.charAt(0) < s2.charAt(0)) {
	            	return -1;
	            }
	            else if(s1.charAt(0) == s2.charAt(0)) {
	            	int a = Integer.parseInt(s1.substring(2));
	            	int b = Integer.parseInt(s2.substring(2));
	            	if(a < b) return -1;            	
	            }
				return 1;
	        }
	    });
		List<String> ans = new ArrayList<>();
		Stack<String> stk = new Stack<>();
			
		int idx = 0;
		while(idx < arr.size()) {		
			if(stk.isEmpty()) {
				stk.push(arr.get(idx++));
			}
			else {
				String stkStr = stk.peek();
				String arrStr = arr.get(idx);
				if(stkStr.charAt(0) > arrStr.charAt(0)) {
	            	stk.push(arrStr);
	            	idx++;
	            }
	            else if(stkStr.charAt(0) == arrStr.charAt(0)) {
	            	int stkNum = Integer.parseInt(stkStr.substring(2));
	            	int arrNum = Integer.parseInt(arrStr.substring(2));
	            	if(stkNum > arrNum) {
		            	stk.push(arrStr);
		            	idx++;
		            } 
	            	else {
	            		ans.add(stkStr);
	            		stk.pop();
	            	}
	            }
	            else {
	            	ans.add(stkStr);
            		stk.pop();
	            }
			}			
		}
		
		while(!stk.isEmpty()) {
			ans.add(stk.peek());
			stk.pop();
		}
		
		boolean sw = true;
		for(int i = 0; i < check.size(); i++) {
			if(!(check.get(i).equals(ans.get(i)))) {
				sw = false;
				break;
			}
		}
		
		if(!sw) System.out.println("BAD");
		else System.out.println("GOOD");
	}
}