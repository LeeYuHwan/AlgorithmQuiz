class Solution {
  public long solution(int a, int b) {
		
	long result = a + b;
		
	if(a < b) {
			for(int i = a + 1; i < b; i++) {
				result += i;
			}
		}
		else if (a > b){
			for(int i = a - 1; i > b; i--) {
				result += i;
			}
		}
      else result = a;
		
	return result;
  }
}