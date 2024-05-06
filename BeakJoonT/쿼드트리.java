import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < n; j++){
                arr[i][j] = String.valueOf(tmp.charAt(j));
            }
        }

        int[] moveH = {0, 0, 1, 1};
        int[] moveW = {0, 1, 0, 1};

        String answer = arr[0][0];
        while (n >= 2) {
            String[][] futureArr = new String[n / 2][n / 2];

            int h = 0;
            int w = 0;

            for (int i = 0; i < n; i += 2){
                for (int j = 0; j < n; j += 2){

                    StringBuilder tmp = new StringBuilder();
                    for (int k = 0; k < 4; k++){
                        int tmpH = moveH[k] + i;
                        int tmpW = moveW[k] + j;

                        String tmpStr = arr[tmpH][tmpW];
                        tmp.append(tmpStr);
                    }

                    if(tmp.toString().equals("0000")) {
                        futureArr[h][w] = "0";
                    }
                    else if(tmp.toString().equals("1111")) {
                        futureArr[h][w] = "1";
                    }
                    else {
                        futureArr[h][w] = "(" + tmp + ")";
                    }
                    w++;
                    w %= n / 2;
                }
                h++;
                h %= n / 2;
            }


            arr = futureArr.clone();
            n /= 2;

            String tmp = "";
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[0].length; j++){
                    tmp += arr[i][j];
                }
            }
            answer = tmp;
        }

        System.out.println(answer);
    }
}
