import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        int h = n / 2;
        int w = n / 2;

        arr[h][w] = 1;

        int cnt = 2;
        int limit = 2;

        int[] moveH = {0, 1, 0, -1};
        int[] moveW = {1, 0, -1, 0};

        while (cnt < n * n) {
            h--;

            for (int i = 0; i < 4; i++){
                int tmpLimit = limit;
                if(i == 0) {
                    tmpLimit -= 1;
                    arr[h][w] = cnt++;
                }

                for (int j = 0; j < tmpLimit; j++){
                    h += moveH[i];
                    w += moveW[i];

                    arr[h][w] = cnt++;
                }
            }

            limit += 2;
        }

        StringBuilder sb = new StringBuilder();
        int answerH = 0, answerW = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(arr[i][j] == target) {
                    answerH = i;
                    answerW = j;
                }

                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(answerH + 1).append(" ").append(answerW + 1);

        System.out.println(sb);
    }
}
