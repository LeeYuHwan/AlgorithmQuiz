import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> minPq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> maxPq = new PriorityQueue<>();

            int idx = 1, cnt = 0;

            sb.append((m + 1) / 2);
            sb.append("\n");

            for (int i = 0; i < m; i++){
                if(i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                if(idx % 2 == 1) {
                    maxPq.offer(Integer.parseInt(st.nextToken()));
                }
                else {
                    minPq.offer(Integer.parseInt(st.nextToken()));
                }

                if(!minPq.isEmpty() && !maxPq.isEmpty() && minPq.peek() > maxPq.peek()) {
                    int tmp = minPq.poll();
                    minPq.offer(maxPq.poll());
                    maxPq.offer(tmp);
                }

                if(idx % 2 == 1){
                    sb.append(maxPq.peek()).append(" ");
                    cnt++;

                    if(cnt % 10 == 0) sb.append("\n");
                }

                idx++;
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
