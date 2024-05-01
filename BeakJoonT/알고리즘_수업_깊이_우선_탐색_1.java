import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24479 {

    static int n, m, r;
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;
    static int cnt = 1;

    static void dfs(int idx){
        if(visited[idx]) return;
        visited[idx] = true;
        answer[idx] = cnt++;

        for (int node : al.get(idx)) {
            if(!visited[node]) dfs(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) al.add(new ArrayList<>());

        visited = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            al.get(u).add(v);
            al.get(v).add(u);
        }

        for (int i = 0; i < al.size(); i++) Collections.sort(al.get(i));

        dfs(r);

        for (int i = 1; i < answer.length; i++) System.out.println(answer[i]);

    }
}
