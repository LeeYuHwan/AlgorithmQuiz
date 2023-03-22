import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q13023 {

    static boolean[] visit;
    static ArrayList<Integer>[] g;
    static boolean flag = false;

    static void dfs(int start, int cnt){
        if(flag) return;
        if(cnt >= 5) {
            flag = true;
            return;
        }

        for(int i : g[start]){
            if(!visit[i]){
                visit[i] = true;
                dfs(i, cnt + 1);
                visit[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        g = new ArrayList[N];

        for(int i = 0; i < N; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g[a].add(b);
            g[b].add(a);
        }

        for(int i = 0; i < N; i++){
            visit[i] = true;
            dfs(i, 1);
            visit[i] = false;
        }

        if(flag) System.out.println(1);
        else System.out.println(0);

    }
}
