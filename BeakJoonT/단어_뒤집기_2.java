import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean sw = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<') {
                sw = true;
                System.out.print(sb.reverse() + "<");
                sb.setLength(0);
            }
            else if(str.charAt(i) == '>') {
                sw = false;
                System.out.print(sb + ">");
                sb.setLength(0);
            }
            else if(str.charAt(i) == ' ') {
                if(sw) System.out.print(sb + " ");
                else System.out.print(sb.reverse() + " ");
                sb.setLength(0);
            }
            else {
                sb.append(str.charAt(i));
            }

        }

        System.out.print(sb.reverse());
    }
}
