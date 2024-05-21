import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxPq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            if(i % 2 == 1) minPq.offer(Integer.parseInt(br.readLine()));
            else maxPq.offer(Integer.parseInt(br.readLine()));

            if(!minPq.isEmpty() && !maxPq.isEmpty() && minPq.peek() > maxPq.peek()) {
                int tmp = minPq.poll();
                minPq.offer(maxPq.poll());
                maxPq.offer(tmp);
            }

            if(i % 2 == 1) sb.append(minPq.peek()).append("\n");
            else sb.append(maxPq.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
