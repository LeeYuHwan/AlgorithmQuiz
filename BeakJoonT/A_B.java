import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16953 {

    static long a, b;
    static int answer = -1;

    static void bfs(){
        Queue<long[]> que = new LinkedList<>();
        que.offer(new long[]{a, 1});

        while (!que.isEmpty()) {
            long[] tmp = que.poll();

            if(tmp[0] == b) {
                answer = (int) tmp[1];
                break;
            }

            if(tmp[0] > b) continue;

            String str = tmp[0] + "1";
            que.offer(new long[] {tmp[0] * 2, tmp[1] + 1});
            que.offer(new long[] {Long.parseLong(str), tmp[1] + 1});

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        bfs();

        System.out.println(answer);
    }
}
