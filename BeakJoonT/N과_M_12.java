import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15666 {

    static int N, M;
    static int[] arr, tmpArr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int idx){
        if(depth == M){
            for(int tmp : tmpArr) sb.append(tmp + " ");
            sb.append("\n");
        }
        else {
            int before = -1;

            for(int i = idx; i < N; i++){
                int now = arr[i];

                if(before != now){
                    before = now;
                    tmpArr[depth] = arr[i];
                    dfs(depth + 1, i);
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmpArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
    }
}
