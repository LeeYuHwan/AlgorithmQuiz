package CodingDojang;
import java.util.Scanner;
public class DartGameQuiz {	
	static int ten_check(String ans, int count, int i, int[] ans_arr) {
		if(ans.charAt(i - 1) == '0' && i - 1 > 0) {
			if(ans.charAt(i - 2) == '1') {
				return ans_arr[count] = 10;
			}
			else return ans_arr[count] = (int)ans.charAt(i-1) % 48;
		}
		else return ans_arr[count] = (int)ans.charAt(i-1) % 48;
	}
	
	static int award_check(String ans, int count, int i, int[] ans_arr) {
		if(i + 1 < ans.length()) {
			if(count == 0) {
				if(ans.charAt(i + 1) == '*') {
					return ans_arr[count] *= 2;
				}
				else if(ans.charAt(i + 1) == '#') {
					return ans_arr[count] *= -1;
				}
				else return ans_arr[count];
			}
			
		    else if(count > 0){
			    if(ans.charAt(i + 1) == '*') {
			    	ans_arr[count - 1] *= 2;
			    	ans_arr[count] *= 2;
				    return ans_arr[count];
			    }
			    else if(ans.charAt(i + 1) == '#') {
				    return ans_arr[count] *= -1;
			    }
			    else return ans_arr[count];
		    }			
        }
		else return ans_arr[count];
		return ans_arr[count];
	}	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String ans  = scanner.nextLine();
		int[] ans_arr = new int[3];
		int result = 0, count = 0;		
		
		for(int i = 0; i < ans.length(); i++) {
			if(ans.charAt(i) == 'S') {
				ten_check(ans, count, i, ans_arr);				
				result = (int)Math.pow(ans_arr[count], 1);
				ans_arr[count] = result;
				award_check(ans, count, i, ans_arr);
				count++;
			}
			
			else if(ans.charAt(i) == 'D') {
				ten_check(ans, count, i, ans_arr);		
				result = (int)Math.pow(ans_arr[count], 2);
				ans_arr[count] = result;
				award_check(ans, count, i, ans_arr);
				count++;
			}
			
			else if(ans.charAt(i) == 'T') {
				ten_check(ans, count, i, ans_arr);				
				result = (int)Math.pow(ans_arr[count], 3);
				ans_arr[count] = result;
				award_check(ans, count, i, ans_arr);
				count++;
			}		
		}	
		System.out.println(ans_arr[0]+ans_arr[1]+ans_arr[2]);
	}
}
