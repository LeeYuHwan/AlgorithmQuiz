import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2615 {

    static int[][] board = new int[19][19];

    static int[] moveH1 = {-1, -1, 0, 1};
    static int[] moveW1 = {0, -1, -1, -1};

    static int rootH, rootW;

    static int[] moveH2 = {1, 1, 0, -1};
    static int[] moveW2 = {0, 1, 1, 1};
    static int cnt;
    static int result, answerH, answerW;
    static boolean sw = false;

    static void findRoot(int h, int w, int idx) {
        rootH = h;
        rootW = w;

        int tmpH = moveH1[idx] + h;
        int tmpW = moveW1[idx] + w;
        if(tmpH >= 0 && tmpW >= 0 && tmpH < 19 && tmpW < 19 && board[tmpH][tmpW] == board[h][w]) findRoot(tmpH, tmpW, idx);
    }
    static void findNode(int h, int w, int idx){
        cnt++;

        int tmpH = moveH2[idx] + h;
        int tmpW = moveW2[idx] + w;
        if(tmpH >= 0 && tmpW >= 0 && tmpH < 19 && tmpW < 19 && board[tmpH][tmpW] == board[h][w]) findNode(tmpH, tmpW, idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                if(board[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        cnt = 0;
                        findRoot(i, j, k);
                        findNode(rootH, rootW, k);
                        if(cnt == 5) {
                            result = board[i][j];
                            answerH = rootH + 1;
                            answerW = rootW + 1;
                            break;
                        }
                    }
                }
                if(cnt == 5) break;
            }
            if(cnt == 5) break;
        }

        if(cnt != 5) System.out.println(0);
        else {
            System.out.println(result);
            System.out.println(answerH + " " + answerW);
        }
    }
}
