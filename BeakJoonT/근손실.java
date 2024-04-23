import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q18429 {

    static int n, k;
    static int answer = 0;
    static int[] arr;
    static boolean[] visited;

    static void dfs(int sum, int idx){
        if(sum < 500) return;

        if(idx == n){
            answer++;
            return;
        }

        for (int i = 0; i < n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            dfs(sum + arr[i] - k, idx + 1);
            visited[i] = false;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(500, 0);

        System.out.println(answer);
    }
}
