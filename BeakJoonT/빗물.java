import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 1; i < W - 1; i++){
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++){
                left = Math.max(left, arr[j]);
            }

            for(int j = W - 1; j > i; j--) {
                right = Math.max(right, arr[j]);
            }

            answer += Math.max(0, Math.min(left, right) - arr[i]);

        }

        System.out.println(answer);

    }
}
