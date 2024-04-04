import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10451 {

    static void dfs(int idx, int[] arr, boolean[] visited){
        if(visited[idx]) return;
        visited[idx] = true;
        dfs(arr[idx], arr, visited);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int test = 0; test < testCase; test++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(arr[i], arr, visited);
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}