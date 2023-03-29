import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair7{
    int first;
    int second;

    public Pair7(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Q14940 {

    static int n;
    static int m;

    static int[][] board;
    static int[][] visit;

    static int[] moveH = {0, 0, 1, -1};
    static int[] moveW = {1, -1, 0, 0};

    static void bfs(int startH, int startW){
        Queue<Pair7> q = new LinkedList<>();
        q.offer(new Pair7(startH, startW));

        while (!q.isEmpty()){
            Pair7 p = q.poll();
            int h = p.first;
            int w = p.second;

            for(int i = 0; i < 4; i++){
                int tmpH = h + moveH[i];
                int tmpW = w + moveW[i];

                if(tmpH < 0 || tmpH >= n || tmpW < 0 || tmpW >= m || board[tmpH][tmpW] == 0 || board[tmpH][tmpW] == 2 || visit[tmpH][tmpW] != 0) continue;
                visit[tmpH][tmpW] = visit[h][w] + 1;

                q.offer(new Pair7(tmpH, tmpW));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visit = new int[n][m];

        int startH = 0, startW = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2) {
                    startH = i;
                    startW = j;
                }
            }
        }

        bfs(startH, startW);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visit[i][j] == 0 && board[i][j] == 1) visit[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }

    }
}
