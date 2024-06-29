import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long answer= Long.MIN_VALUE;
        int end = n - 1;

        if(n % 2 == 1) {
            answer = arr[arr.length - 1];
            end = n - 2;
        }

        for (int i = 0; i < n / 2; i++){
            answer = Math.max(answer, arr[i] + arr[end]);
            end--;
        }

        System.out.println(answer);
    }
}
