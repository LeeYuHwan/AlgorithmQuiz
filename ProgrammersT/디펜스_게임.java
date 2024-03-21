import java.util.Collections;
import java.util.PriorityQueue;


class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < enemy.length; i++){
            pq.offer(enemy[i]);
            n -= enemy[i];

            if(n < 0) {
                if(!pq.isEmpty() && k > 0) {
                    n += pq.poll();
                    k--;
                }
            }

            if(n < 0) break;
            answer++;
        }

        return answer;
    }
}