import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[((h + w) * 2) + 1];

        int N = Integer.parseInt(br.readLine());

        int startIdx = 0, startWay = 0;
        for (int i = 0; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(i == N) startWay = n;
            if(n == 1) {
                if(i == N) startIdx = w - value;
                else arr[w - value] = true;
            }
            else if(n == 2) {
                if(i == N) startIdx = w + h + value;
                else arr[w + h + value] = true;
            }
            else if(n == 3) {
                if(i == N) startIdx = w + value;
                else arr[w + value] = true;
            }
            else {
                if(i == N) startIdx = (w * 2) + h + (h - value);
                else arr[(w * 2) + h + (h - value)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i]) {
                if(startWay == 1 || startWay == 3) {
                    answer += Math.min(Math.abs(startIdx - i), Math.abs(startIdx + Math.abs(((h + w) * 2) - i)));
                }
                else {
                    answer += Math.min(Math.abs(startIdx - i), Math.abs(Math.abs((((h + w) * 2) - startIdx) + i)));
                }
            }
        }

        System.out.println(answer);
    }
}
