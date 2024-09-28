import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;

                if(i < N - 1) {
                    if(arr[i + 1] == 1) arr[i + 1] = 0;
                    else arr[i + 1] = 1;
                }

                if(i < N - 2) {
                    if(arr[i + 2] == 1) arr[i + 2] = 0;
                    else arr[i + 2] = 1;
                }

                answer++;
            }
        }

        System.out.println(answer);
    }
}
