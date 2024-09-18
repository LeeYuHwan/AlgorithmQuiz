import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair3{
    int h, w, dist, pow;
    public Pair3(int h, int w, int dist, int pow){
        this.h = h;
        this.w = w;
        this.dist = dist;
        this.pow = pow;
    }
}
public class Q14442 {

    static int N, M, K, answer = -1;
    static int[] moveH = {-1, 1, 0, 0};
    static int[] moveW = {0, 0, -1, 1};
    static char board[][];
    static boolean visit[][][];

    static void bfs(){
        Queue<Pair3> que = new LinkedList<>();
        que.offer(new Pair3(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!que.isEmpty()){
            Pair3 pair = que.poll();
            int h = pair.h;
            int w = pair.w;
            int dist = pair.dist;
            int pow = pair.pow;

            if(h == N - 1 && w == M - 1) {
                answer = dist;
                return;
            }

            for (int i = 0; i < 4; i++){
                int tmpH = h + moveH[i];
                int tmpW = w + moveW[i];

                if(tmpH < 0 || tmpW < 0 || tmpH >= N || tmpW >= M) continue;

                if (board[tmpH][tmpW] == '0'){
                    if (!visit[tmpH][tmpW][pow]){
                        visit[tmpH][tmpW][pow] = true;
                        que.offer(new Pair3(tmpH, tmpW, dist + 1, pow));
                    }
                }
                else {
                    if(pow < K && !visit[tmpH][tmpW][pow + 1]) {
                        visit[tmpH][tmpW][pow + 1] = true;
                        que.offer(new Pair3(tmpH, tmpW, dist + 1, pow + 1));
                    }
                }

            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visit = new boolean[N][M][K + 1];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        bfs();

        System.out.println(answer);
    }
}
