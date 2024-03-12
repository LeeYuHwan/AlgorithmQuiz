import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
                int answer = -1;

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++){
            que1.offer(queue1[i]);
            que2.offer(queue2[i]);

            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long cnt = 0;
        while (cnt < (queue1.length + queue2.length) * 2L){

            if(sum1 < sum2) {
                long val = que2.poll();

                sum1 += val;
                sum2 -= val;

                que1.offer((int) val);
            }
            else if(sum1 > sum2) {
                long val = que1.poll();

                sum2 += val;
                sum1 -= val;

                que2.offer((int) val);
            }
            else {
                answer = (int) cnt;
                break;
            }

            cnt++;
        }

        return answer;
    }
}