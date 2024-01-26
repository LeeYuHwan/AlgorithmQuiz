import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public String solution(String X, String Y) {
        PriorityQueue<Integer> pqX = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqY = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < X.length(); i++){
            pqX.offer(X.charAt(i) - 48);
        }

        for(int i = 0; i < Y.length(); i++){
            pqY.offer(Y.charAt(i) - 48);
        }

        StringBuilder answerTmp = new StringBuilder();

        while (!pqX.isEmpty()){
            if(pqY.isEmpty()) break;

            int x = pqX.peek();
            int y = pqY.peek();

            if(x < y) pqY.poll();
            else if (y < x) pqX.poll();
            else {
                answerTmp.append(x);
                pqX.poll();
                pqY.poll();
            }

        }

        String answer = answerTmp.toString();

        if (answer.length() == 0) answer = "-1";
        else if(answer.charAt(0) == '0') answer = "0";

        return answer;
    }
}