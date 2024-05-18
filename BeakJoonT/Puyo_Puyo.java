import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q11559 {

    static char[][] board = new char[12][6];
    static int[] moveH = {0, 0, -1, 1};
    static int[] moveW = {1, -1, 0, 0};

    static int bfs(int startH, int startW, int color){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startH, startW});

        char[][] tmpBoard = new char[12][6];
        for (int i = 0; i < 12; i++){
            tmpBoard[i] = board[i].clone();
        }

        tmpBoard[startH][startW] = '.';
        int cnt = 1;

        while (!que.isEmpty()) {

            int[] tmp = que.poll();

            for (int i = 0; i < 4; i++){
                int tmpH = tmp[0] + moveH[i];
                int tmpW = tmp[1] + moveW[i];

                if(tmpH >= 0 && tmpW >= 0 && tmpH < 12 && tmpW < 6 && tmpBoard[tmpH][tmpW] == color) {
                    tmpBoard[tmpH][tmpW] = '.';
                    cnt++;

                    que.offer(new int[] {tmpH, tmpW});
                }
            }

        }

        if(cnt >= 4) {
            board = tmpBoard;
            return 1;
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++){
            String str = br.readLine();

            for (int j = 0; j < 6; j++){
                board[i][j] = str.charAt(j);
            }
        }

        int answer = 0;

        while (true) {

            int sw = 0;

            for (int i = 0; i < 12; i++){
                for (int j = 0; j < 6; j++){
                    if(board[i][j] != '.'){
                        sw += bfs(i, j, board[i][j]);
                    }
                }
            }

            if(sw > 0) answer++;

            for (int j = 0; j < 6; j++){
                int emptyH = -1, emptyW = -1;

                while (true) {
                    boolean sw2 = false;
                    for (int i = 11; i >= 0; i--) {
                        if(board[i][j] == '.') {
                            emptyH = i;
                            emptyW = j;
                        }

                        if(emptyH != -1 && board[i][j] != '.') {
                            board[emptyH][emptyW] = board[i][j];
                            board[i][j] = '.';

                            emptyH = -1;
                            emptyW = -1;

                            sw2 = true;
                            break;
                        }
                    }

                    if(!sw2) break;
                }

            }

            if(sw == 0) break;
        }

        System.out.println(answer);
    }
}
