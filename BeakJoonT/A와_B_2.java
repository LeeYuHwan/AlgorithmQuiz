import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12919 {

    static String S;
    static int answer = 0;

    static int dfs(String t){

        if(S.length() == t.length()) {
            if(S.equals(t)) return 1;
            return 0;
        }

        int tmp = 0;

        if (t.charAt(t.length() - 1) == 'A'){
            tmp += dfs(t.substring(0, t.length() - 1));
        }

        if(t.charAt(0) == 'B'){
            tmp += dfs(new StringBuffer(t.substring(1, t.length())).reverse().toString());
        }

        return tmp > 0 ? 1 : 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();

        int answer = dfs(T);

        System.out.println(answer);

    }
}
