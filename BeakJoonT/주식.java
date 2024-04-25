import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            int max = -1;
            long answer = 0;
            for (int i = n - 1; i >= 0; i--) {
                if(max < arr[i]) max = arr[i];
                else if(max > arr[i]) answer += max - arr[i];
            }

            System.out.println(answer);
        }
    }
}
