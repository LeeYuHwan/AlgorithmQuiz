import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] answerArr = new int[n];
        for (int t = 0; t < n; t++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            Integer[] arr = new Integer[p];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < p; i++) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr, Comparator.reverseOrder());

            int min;
            if(p > l) {
                min = arr[l - 1];
            }
            else if(p == l){
                min = arr[p - 1];
            }
            else {
                min = 1;
            }

            answerArr[t] = min;
        }

        Arrays.sort(answerArr);

        int answer = 0;
        for (int i = 0; i < n; i++){
            if(answerArr[i] <= m) {
                m -= answerArr[i];
                answer++;
            }
            else break;
        }

        System.out.println(answer);
    }
}
