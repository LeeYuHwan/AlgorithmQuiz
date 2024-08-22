import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));

        int answer = 0;
        while (!pq.isEmpty()){
            int size = pq.size();
            int value = pq.poll();

            answer = Math.max(answer, value * size);
        }

        System.out.println(answer);
    }
}
