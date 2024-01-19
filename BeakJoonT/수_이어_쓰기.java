import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int idx = 0;
        for(int num = 1; num <= 30000; num++){
            String tmp = Integer.toString(num);

            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == str.charAt(idx)){
                    idx++;
                }

                if(idx == str.length()) {
                    System.out.println(num);
                    return;
                }
            }
        }
    }
}
