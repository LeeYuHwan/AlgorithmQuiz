import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = 1;

        while (k > n) n *= 2;
        System.out.print(n + " ");

        int cnt = 0;
        while (k > 0) {
            if(k % n == 0) break;
            else {
                n /= 2;
                cnt++;
            }
        }

        System.out.print(cnt);

    }
}
