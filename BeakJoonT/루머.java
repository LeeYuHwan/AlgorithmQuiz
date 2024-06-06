import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q19538 {

    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static int[] answers;
    static int[] neighbor;
    static Queue<Integer> que = new LinkedList<>();

    static void bfs(){
        while (!que.isEmpty()){
            int currentNode = que.poll();

            for (int node : al.get(currentNode)) {
                neighbor[node]++;

                if(answers[node] == -1 && (al.get(node).size() + 1) / 2 <= neighbor[node]) {
                    que.offer(node);
                    answers[node] = (answers[currentNode] + 1);
                }

            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        answers = new int[n + 1];
        neighbor = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
            answers[i] = -1;
        }

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            while (true) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) break;
                al.get(i).add(value);
            }
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int node = Integer.parseInt(st.nextToken());
            answers[node] = 0;
            que.offer(node);
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answers.length; i++) sb.append(answers[i]).append(" ");

        System.out.println(sb);
    }
}
