import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
    static int N, M, H;
    static int[][][] board;
    static int[][][] cnt;
    static int[] moveLayer = {0, 0, 0, 0, -1, 1};
    static int[] moveH = {-1, 1, 0, 0, 0, 0};
    static int[] moveW = {0, 0, 1, -1, 0, 0};
    static Queue<int []> que = new LinkedList<>();

    static void bfs(){
        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            for (int i = 0; i < 6; i++){
                int tmpLayer = tmp[0] + moveLayer[i];
                int tmpH = tmp[1] + moveH[i];
                int tmpW = tmp[2] + moveW[i];

                if(tmpH < 0 || tmpW < 0 || tmpH >= N || tmpW >= M || tmpLayer < 0 || tmpLayer >= H
                        || board[tmpLayer][tmpH][tmpW] != 0) continue;

                board[tmpLayer][tmpH][tmpW] = 1;
                cnt[tmpLayer][tmpH][tmpW] = cnt[tmp[0]][tmp[1]][tmp[2]] + 1;

                que.offer(new int[] {tmpLayer, tmpH, tmpW});
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int h = 0; h < H; h++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(board[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, cnt[h][i][j]);
                }
            }
        }

        if(answer == 1) System.out.println(0);
        else System.out.println(answer - 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][N][M];
        cnt = new int[H][N][M];

        for (int h = 0; h < H; h++){
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++){
                    board[h][i][j] = Integer.parseInt(st.nextToken());
                    if(board[h][i][j] == 1) cnt[h][i][j] = 1;
                }
            }
        }

        for (int h = 0; h < H; h++){
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(board[h][i][j] == 1) que.offer(new int[] {h, i, j});
                }
            }
        }

        bfs();
    }
}
