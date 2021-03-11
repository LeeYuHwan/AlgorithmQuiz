import java.util.Arrays;
import java.util.PriorityQueue;

class Pair2 implements Comparable<Pair2> {
    int first, second;

    Pair2(int f, int s) {
        this.first = f;
        this.second = s;
    }

    public int compareTo(Pair2 p) {
        if(this.first < p.first) {
            return -1; // 오름차순
        }
        else if(this.first == p.first) {
            if(this.second < p.second) {
                return -1;
            }
        }
        return 1;
    }
}


class Solution {
    public int solution(int[][] jobs) {

        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        int count = 0;
        int idx = 0;
        int time = 0;
        int sum = 0;
        while(count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Pair2(jobs[idx][1], jobs[idx][0]));
                System.out.println(jobs[idx][1] + " " + jobs[idx][0]);
                idx++;
            }

            if(pq.isEmpty()) {
                time = jobs[idx][0];
            }
            else {
                Pair2 p = pq.poll();            
                sum += p.first + time - p.second;
                time += p.first;
                count++;
            }
        }
        return sum / jobs.length;
    }
}