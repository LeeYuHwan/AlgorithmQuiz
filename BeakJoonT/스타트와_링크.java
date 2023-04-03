import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {

    static int N;
    static int[][] board;
    static boolean[] visit;

    static int answer = Integer.MAX_VALUE;

    static void backTracking(int idx, int cnt){
        if(cnt == N / 2){
            diff();
            return;
        }

        for(int i = idx; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                backTracking(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int startT = 0;
        int linkT = 0;

        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(visit[i] && visit[j]) startT += (board[i][j] + board[j][i]);
                if(!visit[i] && !visit[j]) linkT += (board[i][j] + board[j][i]);
            }
        }

        answer = Math.min(answer, Math.abs(startT - linkT));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);

        System.out.println(answer);

    }
}
