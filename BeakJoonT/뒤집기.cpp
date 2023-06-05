import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int one = 0;
        int zero = 0;

        String tmp = "" + s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) != s.charAt(i)) {
                if(tmp.charAt(0) == '1') one++;
                else zero++;

                tmp = "";
            }
            tmp += s.charAt(i);
        }

        if(tmp.charAt(0) == '1') one++;
        else zero++;

        if(one < zero) System.out.println(one);
        else System.out.println(zero);


    }
}
