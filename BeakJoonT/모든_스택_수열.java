import java.io.*;
import java.util.StringTokenizer;

public class Q23284 {
    static int n;
    static int[] arr;

    static void backTracking(int idx, int cnt) throws IOException {
        if(idx == n){
            for(int i = 0; i < n ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++){
            boolean flag = true;

            arr[idx] = i;

            for(int j = 0; j < idx; j++){
                if(arr[j] == arr[idx]) flag = false;
            }

            if(flag){
                if(idx > 0 && arr[idx - 1] < arr[idx] && arr[idx] < cnt) break;

                if(cnt <= arr[idx]){
                    backTracking(idx + 1, arr[idx] + 1);
                }
                else{
                    backTracking(idx + 1, cnt);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        backTracking(0, 0);

    }
}
