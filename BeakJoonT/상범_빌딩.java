import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6593 {

    static int L, R, C;
    static int answer;
    static char[][][] board;
    static boolean[][][] visited;
    static int[] moveF = {0, 0, 0, 0, -1, 1};
    static int[] moveH = {0, 0, -1, 1, 0, 0};
    static int[] moveW = {-1, 1, 0, 0, 0, 0};

    static void bfs(int startF, int startH, int startW) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startF, startH, startW, 0});

        answer = 0;
        while (!que.isEmpty()) {
            int[] tmp = que.poll();

            for (int i = 0; i < 6; i++){
                int tmpF = tmp[0] + moveF[i];
                int tmpH = tmp[1] + moveH[i];
                int tmpW = tmp[2] + moveW[i];

                if(tmpF >= 0 && tmpF < L && tmpH >= 0 && tmpH < R && tmpW >= 0 && tmpW < C && !visited[tmpF][tmpH][tmpW]) {
                    if(board[tmpF][tmpH][tmpW] == 'E') {
                        answer = tmp[3] + 1;
                        break;
                    }

                    if(board[tmpF][tmpH][tmpW] == '.') {
                        visited[tmpF][tmpH][tmpW] = true;
                        que.offer(new int[] {tmpF, tmpH, tmpW, tmp[3] + 1});
                    }
                }
            }
        }

        if(answer == 0) System.out.println("Trapped!");
        else System.out.println("Escaped in " + answer + " minute(s).");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            board = new char[L][R][C];
            visited = new boolean[L][R][C];

            int startF = 0, startH = 0, startW = 0;
            for (int i = 0; i < L; i++){
                for (int j = 0; j < R; j++){
                    String str = br.readLine();
                    for (int k = 0; k < C; k++){
                        board[i][j][k] = str.charAt(k);

                        if(board[i][j][k] == 'S') {
                            startF = i;
                            startH = j;
                            startW = k;
                        }
                    }
                }
                br.readLine();
            }

            bfs(startF, startH, startW);

        }

    }
}
