import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        StringBuilder tmp = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == 'K') {
                max.insert(0, tmp);
                tmp.setLength(0);
                tmp.append('5');
            }
            else {
                if(tmp.length() == 0) tmp.append('1');
                else {
                    if(tmp.charAt(0) == '5') tmp.append('0');
                    else tmp.append('1');
                }
            }
        }
        max.insert(0, tmp);
        tmp.setLength(0);

        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'K') {
                min.append(tmp).append('5');
                tmp.setLength(0);
            }
            else {
                if(tmp.length() == 0) tmp.append('1');
                else tmp.append('0');
            }
        }
        min.append(tmp);

        System.out.println(max);
        System.out.println(min);

    }
}
