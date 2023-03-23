import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair5{
    int first;
    int second;

    public Pair5(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Q2589 {

    static int N, M, maxH, maxW, max = 0;
    static char[][] board;

    static int[] moveH = {0, 0, 1, -1};
    static int[] moveW = {1, -1, 0, 0};

    static void bfs(int startH, int startW, int[][] visit){
        Queue<Pair5> q = new LinkedList<>();
        q.offer(new Pair5(startH, startW));

        visit[startH][startW] = 1;

        while (!q.isEmpty()){
            Pair5 p = q.poll();
            int h = p.first;
            int w = p.second;

            for(int i = 0; i < 4; i++){
                int tmpH = h + moveH[i];
                int tmpW = w + moveW[i];

                if(tmpH < 0 || tmpH >= N || tmpW < 0 || tmpW >= M || board[tmpH][tmpW] == 'W' || visit[tmpH][tmpW] != 0) continue;
                    visit[tmpH][tmpW] = visit[h][w] + 1;
                    if(max < visit[tmpH][tmpW]) {
                        max = visit[tmpH][tmpW];
                        maxH = tmpH;
                        maxW = tmpW;
                    }
                    q.offer(new Pair5(tmpH, tmpW));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int[][] visit = new int[N][M];
                if(board[i][j] == 'L' && visit[i][j] == 0) {
                    bfs(i, j, visit);
                }
            }
        }

        System.out.println(max - 1);

    }
}
