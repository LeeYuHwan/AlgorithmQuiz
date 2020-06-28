class Solution {
  public String solution(int n) {
      int[] tmp = {1, 2 ,4};
		
		int num = (n - 1) / 3;
		int sw = 1;
		long result = 0;
		String answer = "";
		
		result = tmp[(n - 1) % tmp.length];
		if(n > 3) result += tmp[(num - 1) % tmp.length] * 10;
		
		while(num > 3) {
			
			num = (num - 1) / 3;
			sw++;
			result += tmp[(num - 1) % tmp.length] * (long)Math.pow(10, sw);
			
		}		
		System.out.println(result);
		answer = answer + Long.toString(result);
		
      return answer;
  }
}