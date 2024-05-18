import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3109 {

    static int r, c;
    static char[][] board;

    static boolean dfs(int h, int w){
        if(board[h][w] == '.'){
            board[h][w] ='-';

            if(w == c - 1) return true;

            if(h > 0) {
                if(dfs(h - 1, w + 1)) return true;
            }

            if(dfs(h, w + 1)) return true;

            if(h < r - 1) {
                if(dfs(h + 1, w + 1)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++){
            String str = br.readLine();

            for (int j = 0; j < c; j++){
                board[i][j] = str.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < r; i++){
            if (dfs(i, 0)) answer++;
        }

        System.out.println(answer);
    }
}
