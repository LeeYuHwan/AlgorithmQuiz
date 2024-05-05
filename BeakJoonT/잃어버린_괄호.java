import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("-");

        int answer = 0;
        for (int i = 0; i < str.length; i++){
            String[] plusArr = str[i].split("\\+");

            int tmp = 0;
            for (int j = 0; j < plusArr.length; j++){
                tmp += Integer.parseInt(plusArr[j]);
            }

            if(i == 0) answer = tmp;
            else answer -= tmp;
        }

        System.out.println(answer);
    }
}
