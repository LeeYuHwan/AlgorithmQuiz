import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11725 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] answer;
    static boolean[] visited;
    static void dfs(int node){
        visited[node] = true;
        for (int i = 0; i < graph.get(node).size(); i++) {
            if(!visited[graph.get(node).get(i)]) {
                answer[graph.get(node).get(i)] = node;
                dfs(graph.get(node).get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        dfs(1);

        for (int i = 2; i < answer.length; i++){
            System.out.println(answer[i]);
        }

    }
}
