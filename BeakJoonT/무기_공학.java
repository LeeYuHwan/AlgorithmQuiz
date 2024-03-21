import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18430 {

    static int N, M, answer = 0;
    static int[][] board;
    static boolean[][] visited;
    static int[] moveH1 = {-1, -1, 0, 0};
    static int[] moveW1 = {0, 0, -1, 1};
    static int[] moveH2 = {0, 0, 1, 1};
    static int[] moveW2 = {1, -1, 0, 0};

    static void dfs(int h, int w, int cnt, int sum){
        if(cnt == N * M) {
            answer = Math.max(answer, sum);
            return;
        }

        if (w == M) {
            w = 0;
            h++;
        }

        if(!visited[h][w]){
            for (int i = 0; i < 4; i++){
                int tmpH1 = h + moveH1[i];
                int tmpW1 = w + moveW1[i];
                int tmpH2 = h + moveH2[i];
                int tmpW2 = w + moveW2[i];

                if(tmpH1 >= 0 && tmpH2 >= 0 && tmpH1 < N && tmpH2 < N && tmpW1 >= 0 && tmpW2 >= 0 && tmpW1 < M && tmpW2 < M
                        && !visited[tmpH1][tmpW1] && !visited[tmpH2][tmpW2]){
                    visited[h][w] = true;
                    visited[tmpH1][tmpW1] = true;
                    visited[tmpH2][tmpW2] = true;
                    dfs(h, w + 1, cnt + 1, sum + board[tmpH1][tmpW1] + board[tmpH2][tmpW2] + (board[h][w] * 2));
                    visited[h][w] = false;
                    visited[tmpH1][tmpW1] = false;
                    visited[tmpH2][tmpW2] = false;
                }
            }
        }

        dfs(h, w + 1, cnt + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(answer);
    }
}
