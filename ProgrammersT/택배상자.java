import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stk = new Stack<>();

        int answer = 0;
        int orderIdx = 0;

        for (int i = 1; i <= order.length; i++){
            if(i == order[orderIdx]) {
                orderIdx++;
                answer++;
            }
            else stk.push(i);

            while (!stk.isEmpty()){
                if(stk.peek() != order[orderIdx]) break;
                else {
                    answer++;
                    orderIdx++;
                    stk.pop();
                }
            }
        }

        return answer;
    }
}