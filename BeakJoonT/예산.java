import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int start = 0, end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());

        while (start <= end) {
            int mid = (start + end) / 2;

            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] > mid) tmp += mid;
                else tmp += arr[i];
            }

            if(tmp > m) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(end);
    }
}
