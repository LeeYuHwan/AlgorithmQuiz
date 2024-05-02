import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++){
            int start = 0, end = n - 1;

            while (start < end) {
                if(start == i) start++;
                else if(end == i) end--;

                if(start >= end) break;

                int sum = arr[start] + arr[end];

                if(sum == arr[i]) {
                    answer++;
                    break;
                }
                else if(sum < arr[i]) start++;
                else end--;
            }
        }

        System.out.println(answer);
    }
}
