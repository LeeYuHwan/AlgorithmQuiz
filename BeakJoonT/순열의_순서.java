import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        long[] f = new long[21];
        boolean[] visited = new boolean[21];

        f[0] = 1;
        for (int i = 1; i <= 20; i++) f[i] = f[i - 1] * i;

        int[] check = new int[n];

        if(q == 1) {
            long k = Long.parseLong(st.nextToken());

            for (int i = 0; i < n; i++){
                for (int j = 1; j <= n; j++){
                    if(visited[j]) continue;

                    if(f[n - i - 1] < k) k -= f[n - i - 1];
                    else {
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
        }
        else {
            for (int i = 0; i < n; i++) check[i] = Integer.parseInt(st.nextToken());

            long answer = 1L;

            for (int i = 0; i < n; i++){
                for (int j = 1; j < check[i]; j++){
                    if(!visited[j]) answer += f[n - i - 1];
                }
                visited[check[i]] = true;
            }

            System.out.println(answer);
        }
    }
}
