import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q2210 {

    static int[][] board = new int[5][5];
    static int[] moveH = {0, 0, 1, -1};
    static int[] moveW = {1, -1, 0, 0};
    static HashSet<String> hs = new HashSet<>();

    static void dfs(int h, int w, String sum, int cnt) {
        if(cnt == 6) {
            hs.add(sum);
            return;
        }

        for (int i = 0; i < 4; i++){
            int tmpH = moveH[i] + h;
            int tmpW = moveW[i] + w;

            if(tmpH >= 0 && tmpW >= 0 && tmpH < 5 && tmpW < 5) {
                dfs(tmpH, tmpW, sum + board[tmpH][tmpW], cnt + 1);
            }
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                dfs(i, j, "" + board[i][j], 1);
            }
        }

        System.out.println(hs.size());
    }
}
