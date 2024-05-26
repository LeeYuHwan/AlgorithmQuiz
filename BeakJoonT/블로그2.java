import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int answer = 1;
        char check = str.charAt(0);
        for (int i = 1; i < n; i++){
            if(str.charAt(i) != check) {
                if(str.charAt(i) != str.charAt(0)){
                    answer++;
                }

                check = str.charAt(i);
            }
        }

        System.out.println(answer);
    }
}
