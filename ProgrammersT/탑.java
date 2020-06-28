import java.util.Stack;
class Solution {
    public int[] solution(int[] heights) {
        Stack stk = new Stack();
		int[] answer = heights;
		
		for(int i = 0; i < heights.length; i++) {
			stk.push(heights[i]);		
		}
		
		

		for(int i = answer.length - 2; i >= 0; i--) {
			boolean sw = false;
			int stk_size = stk.size() - 1;
			for(int j = i; j >= 0; j--) {
				int peek = (int)stk.peek();
				if(peek < answer[j]) {
					stk.pop();			
					answer[i + 1] = stk_size;
					sw = true;
					break;				
				}
				stk_size--;
			}
			if(sw == false) {
				stk.pop();
				answer[i + 1] = 0;
			}
		}
		answer[0] = 0;
        return answer;
    }
}