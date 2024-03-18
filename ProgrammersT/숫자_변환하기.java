import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        HashSet<Integer> hs = new HashSet<>();
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[] {x, 0});

        int answer = -1;

        while (!que.isEmpty()){
            int[] tmp = que.poll();

            if(tmp[0] == y) {
                answer = tmp[1];
                break;
            }

            if(tmp[0] <= y && !hs.contains(tmp[0])) {
                hs.add(tmp[0]);

                que.offer(new int[] {tmp[0] + n, tmp[1] + 1});
                que.offer(new int[] {tmp[0] * 2, tmp[1] + 1});
                que.offer(new int[] {tmp[0] * 3, tmp[1] + 1});
            }
        }

        return answer;
    }
}