import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2606 {

    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;

    static void dfs(int node){
        if(visited[node]) return;

        visited[node] = true;
        answer++;
        for (int i = 0; i < al.get(node).size(); i++){
            dfs(al.get(node).get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) al.add(new ArrayList<>());
        visited = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            al.get(u).add(v);
            al.get(v).add(u);
        }

        dfs(1);

        System.out.println(answer - 1);
    }
}
