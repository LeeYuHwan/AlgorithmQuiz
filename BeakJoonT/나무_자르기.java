import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0, answer = 0;

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        while (answer < max) {
            int mid = (max + answer) / 2;

            long sum = 0;
            for (int tree : trees) if((tree - mid) > 0) sum += tree - mid;

            if(sum < m) max = mid;
            else answer = mid + 1;
        }

        System.out.println(answer - 1);
    }
}
