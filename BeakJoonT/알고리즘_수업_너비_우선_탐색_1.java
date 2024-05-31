import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24444 {
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static int[] answers;
    static int cnt = 1;
    static boolean[] visited;

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        answers[start] = cnt++;
        visited[start] = true;

        while (!que.isEmpty()) {
            int node = que.poll();

            for (int i = 0; i < al.get(node).size(); i++){
                if(!visited[al.get(node).get(i)]) {
                    visited[al.get(node).get(i)] = true;
                    answers[al.get(node).get(i)] = cnt++;
                    que.offer(al.get(node).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) al.add(new ArrayList<>());

        visited = new boolean[n + 1];
        answers = new int[n + 1];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            al.get(u).add(v);
            al.get(v).add(u);
        }

        for (int i = 0; i <= n; i++) Collections.sort(al.get(i));
        
        bfs(r);

        for (int i = 1; i < answers.length; i++) System.out.println(answers[i]);
    }
}
