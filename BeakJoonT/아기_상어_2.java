import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair12{
    int first;
    int second;

    public Pair12(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Q17086 {
    static int N, M;

    static int[] move_h = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] move_w = {0, 0, -1, 1, -1, 1, -1, 1};

    static int[][] arr = new int[51][51];

    static void bfs(int startH, int startW) {
        Queue<Pair12> q = new LinkedList<>();
        q.offer(new Pair12(startH, startW));

        while (!q.isEmpty()) {
            Pair12 p = q.poll();
            int h = p.first;
            int w = p.second;

            for (int i = 0; i < 8; i++) {
                int tmp_w = w + move_w[i];
                int tmp_h = h + move_h[i];

                if(tmp_h < 0 || tmp_w < 0 || tmp_h >= N || tmp_w >= M) continue;

                if(arr[tmp_h][tmp_w] == 0) {
                    arr[tmp_h][tmp_w] = arr[h][w] + 1;
                    q.offer(new Pair12(tmp_h, tmp_w));
                }
                else if(arr[tmp_h][tmp_w] > arr[h][w] + 1){
                    arr[tmp_h][tmp_w] = arr[h][w] + 1;
                    q.offer(new Pair12(tmp_h, tmp_w));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1){
                    bfs(i, j);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                answer = Math.max(answer, arr[i][j]);
            }
        }

        System.out.println(answer - 1);

    }
}
