import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {

    static int n, r, c;
    static int answer = 0;

    static void dfs(int size, int r, int c){
        if (size == 1) return;
        else if(r < size / 2 && c < size / 2){
            dfs(size / 2, r, c);
        }
        else if(r < size / 2 && c >= size / 2){
            answer += (size * size / 4);
            dfs(size / 2, r, c - size / 2);
        }
        else if(r >= size / 2 && c < size / 2){
            answer += (size * size / 4) * 2;
            dfs(size / 2, r - size / 2, c);
        }
        else {
            answer += (size * size / 4) * 3;
            dfs(size / 2, r - size / 2, c - size / 2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dfs((int) Math.pow(2, n), r , c);

        System.out.println(answer);

    }
}
