import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N && S > 0; i++){
            int idx = i, tmp = arr[i];

            for(int j = i + 1; j < N && j - i <= S; j++){
                if(arr[j] > tmp){
                    tmp = arr[j];
                    idx = j;
                }
            }

            if(idx != i){
                S -= (idx - i);
                for(int j = idx; j > i; j--){
                    arr[j] = arr[j - 1];
                }
                arr[i] = tmp;
            }
        }
        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
