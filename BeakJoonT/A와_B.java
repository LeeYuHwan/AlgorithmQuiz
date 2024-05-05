import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        int answer = 0;
        while (t.length() > s.length()) {
            if(t.charAt(t.length() - 1) == 'A') t.setLength(t.length() - 1);
            else {
                t.setLength(t.length() - 1);
                t.reverse();
            }

            if(s.toString().equals(t.toString())) {
                answer = 1;
                break;
            }
        }

        System.out.println(answer);
    }
}
