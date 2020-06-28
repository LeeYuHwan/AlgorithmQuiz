import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stk = new Stack<Integer>();
		int result = 0;
		stk.push(0);
		for(int i = 0; i < moves.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[j][moves[i] - 1] > 0) {
					if(stk.peek() == board[j][moves[i] - 1]) {
						stk.pop();
						result += 2;
						
					} 
					else {
						stk.push(board[j][moves[i] - 1]);
					}
                    board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}
        return result;
    }
}