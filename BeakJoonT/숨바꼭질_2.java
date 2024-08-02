import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12851 {
    static int n, k;
    static int[] moveN = {-1, 1, 2};
    static int[] timeArr;
    static int answerCnt = 0;


    static void bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.offer(n);

        timeArr = new int[100001];

        if (n == k) {
            answerCnt++;
            return;
        }

        while (!que.isEmpty()){
            int currentN = que.poll();

            for (int i = 0; i < 3; i++){
                int nextN;
                if(i == 2) nextN = currentN * moveN[i];
                else nextN = currentN + moveN[i];

                if(nextN < 0 || nextN > 100000 || (timeArr[nextN] != 0 && timeArr[nextN] < timeArr[currentN] + 1)) continue;
                que.offer(nextN);
                timeArr[nextN] = timeArr[currentN] + 1;

                if(nextN == k) answerCnt++;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(timeArr[k]);
        System.out.println(answerCnt);
    }
}
