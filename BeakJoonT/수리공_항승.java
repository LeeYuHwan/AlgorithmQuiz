import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        float[] arr = new float[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Float.parseFloat(st.nextToken());

        Arrays.sort(arr);

        float tmp = (float) (arr[0] - 0.5 + l);
        int answer = 1;

        for (int i = 1 ; i < n; i++){
            if(tmp < (arr[i] + 0.5)) {
                tmp = (float) (arr[i] - 0.5 + l);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
