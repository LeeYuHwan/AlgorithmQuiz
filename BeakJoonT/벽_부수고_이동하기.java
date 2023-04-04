import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair9{
    int first;
    int second;
    int cnt;
    boolean sw;

    public Pair9(int first, int second, int cnt, boolean sw) {
        this.first = first;
        this.second = second;
        this.cnt = cnt;
        this.sw = sw;
    }
}

public class Q2206 {

    static int N;
    static int M;

    static char[][] board;
    static boolean[][][] visit;

    static int[] moveH = {0, 0, 1, -1};
    static int[] moveW = {1, -1, 0, 0};

    static int answer = -1;

    static void bfs(int startH, int startW){
        Queue<Pair9> q = new LinkedList<>();
        q.offer(new Pair9(startH, startW, 1, false));

        visit[startH][startW][0] = false;

        while (!q.isEmpty()){
            Pair9 p = q.poll();
            int h = p.first;
            int w = p.second;
            int cnt = p.cnt;

            if(h == N - 1 && w == M - 1){
                answer = cnt;
                return;
            }

            for(int i = 0; i < 4; i++){
                int tmpH = h + moveH[i];
                int tmpW = w + moveW[i];
                int tmpCnt = cnt + 1;

                if(tmpH < 0 || tmpH >= N || tmpW < 0 || tmpW >= M) continue;

                if(board[tmpH][tmpW] == '0'){
                    if(!p.sw && !visit[tmpH][tmpW][0]){
                        visit[tmpH][tmpW][0] = true;
                        q.offer(new Pair9(tmpH, tmpW, tmpCnt, false));
                    }
                    else if(p.sw && !visit[tmpH][tmpW][1]){
                        visit[tmpH][tmpW][1] = true;
                        q.offer(new Pair9(tmpH, tmpW, tmpCnt, true));
                    }
                }
                else if(board[tmpH][tmpW] == '1' && !p.sw){
                    visit[tmpH][tmpW][1] = true;
                    q.offer(new Pair9(tmpH, tmpW, tmpCnt, true));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visit = new boolean[N][M][2];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        bfs(0, 0);

        System.out.println(answer);

    }
}
