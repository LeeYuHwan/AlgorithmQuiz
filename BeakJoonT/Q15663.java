import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15663 {

    static int N, M;
    static int[] arr;
    static int[] answerArr;
    static boolean[] visited;

    static void dfs(int depth){
        if(depth == M) {
            for (int value : answerArr) System.out.print(value + " ");
            System.out.println();
            return;
        }

        int before = -1;

        for (int i = 0; i < N; i++){
            int now = arr[i];

            if(!visited[i] && before != now) {
                before = now;
                visited[i] = true;
                answerArr[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answerArr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        dfs(0);
    }
}
