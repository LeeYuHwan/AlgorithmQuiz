import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q4803 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean correctSw;

    static void dfs(int node, int preNode){
        if(visited[node] || !correctSw) {
            correctSw = false;
            return;
        }
        visited[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            if(graph.get(node).get(i) != preNode) dfs(graph.get(node).get(i), node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            graph = new ArrayList<>();
            visited = new boolean[n + 1];

            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());

                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }

            int answer = 0;
            for (int i = 1; i <= n; i++){
                correctSw = true;
                dfs(i, 0);

                if(correctSw) answer++;
            }

            System.out.print("Case " + T + ": ");
            if(answer > 1) System.out.println("A forest of " + answer + " trees.");
            else if(answer == 1) System.out.println("There is one tree.");
            else System.out.println("No trees.");

            T++;
        }

    }
}
