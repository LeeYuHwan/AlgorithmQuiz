import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24480 {

    static int[] visited;
    static ArrayList<ArrayList<Integer>> board = new ArrayList<>();
    static int cnt = 0;

    static void dfs(int node){
        if(visited[node] == 0){
            cnt++;
            visited[node] = cnt;

            for(int idx : board.get(node)) dfs(idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            board.add(tmp);
        }
        visited = new int[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board.get(u).add(v);
            board.get(v).add(u);

        }

        for (int i = 0; i < board.size(); i++) Collections.sort(board.get(i), Collections.reverseOrder());

        dfs(R);

        for(int i = 1; i < visited.length; i++) System.out.println(visited[i]);

    }
}
