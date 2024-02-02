import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1012 {

    static int N, M;
    static boolean[][] board;
    static boolean[][] visited;
    static int[] moveH = {-1, 1, 0, 0};
    static int[] moveW = {0, 0, -1, 1};

    static void bfs(int h, int w){
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[] {h, w});

        while (!que.isEmpty()){
            int[] tmp = que.poll();

            for (int i = 0 ; i < 4; i++){
                int tmpH = tmp[0] + moveH[i];
                int tmpW = tmp[1] + moveW[i];

                if(tmpH < 0 || tmpW < 0 || tmpH >= N || tmpW >= M || visited[tmpH][tmpW] || !board[tmpH][tmpW]) continue;

                visited[tmpH][tmpW] = true;
                que.offer(new int[] {tmpH, tmpW});
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            board = new boolean[N][M];
            visited = new boolean[N][M];

            for (int idx = 0; idx < K; idx++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = true;
            }

            int answer = 0;

            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[i].length; j++){
                    if(!visited[i][j] && board[i][j]){
                        answer++;
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(answer);

        }



    }
}
