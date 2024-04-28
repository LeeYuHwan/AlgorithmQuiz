import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10974 {

    static int n;
    static boolean[] visited;

    static void permutation(int idx, int[] arr){
        if(n == idx) {
            for (int i = 0; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[idx] = i + 1;
            permutation(idx + 1, arr);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        permutation(0, new int[n]);
    }
}
