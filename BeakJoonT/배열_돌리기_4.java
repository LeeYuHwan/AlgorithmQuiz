import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17406 {
    static int[][] A;
    static int[][] task;
    static int N;
    static int M;
    static int K;
    static int answer = 101 * 51 * 51;

    static void dfs(int[] doTask, boolean[] visited, int cnt){

        if (cnt == K){
            answer = Math.min(answer, processing(doTask));
            return;
        }

        for (int i = 0; i < K; i++){
            if(!visited[i]){
                visited[i] = true;
                doTask[cnt] = i;
                dfs(doTask, visited, cnt + 1);
                visited[i] = false;
            }
        }

    }

    static int processing(int[] doTask){

        int[][] arr = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                arr[i][j] = A[i][j];
            }
        }

        for (int t = 0; t < K; t++){
            int n = task[doTask[t]][0];
            int m = task[doTask[t]][1];
            int k = task[doTask[t]][2];

            while (k > 0) {
                int h = n - k;
                int w = m - k + 1;

                int tmp = arr[h][w - 1];
                for (int i = 1; i < (k * 2) + 1; i++){
                    int oldValue = arr[h][w];
                    arr[h][w] = tmp;
                    tmp = oldValue;
                    w++;
                }

                h = n - k + 1;
                w = m + k;

                for (int i = 1; i < (k * 2) + 1; i++){
                    int oldValue = arr[h][w];
                    arr[h][w] = tmp;
                    tmp = oldValue;
                    h++;
                }

                h = n + k;
                w = m + k - 1;

                for (int i = 1; i < (k * 2) + 1; i++){
                    int oldValue = arr[h][w];
                    arr[h][w] = tmp;
                    tmp = oldValue;
                    w--;
                }

                h = n + k - 1;
                w = m - k;

                for (int i = 1; i < (k * 2) + 1; i++){
                    int oldValue = arr[h][w];
                    arr[h][w] = tmp;
                    tmp = oldValue;
                    h--;
                }

                k--;
            }


        }

        return minSum(arr);
    }

    static int minSum(int[][] arr){
        int minSumValue = 101 * 51 * 51;
        for (int i = 1; i < arr.length; i++){
            int sum = 0;
            for (int j = 1; j < arr[0].length; j++){
                sum += arr[i][j];
            }

            minSumValue = Math.min(minSumValue, sum);
        }
        return minSumValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        task = new int[K][3];
        boolean[] visited = new boolean[K];

        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            task[i][0] = n;
            task[i][1] = m;
            task[i][2] = k;
        }

        dfs(new int[K], visited, 0);

        System.out.println(answer);

    }
}
