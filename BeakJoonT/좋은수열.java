import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2661 {
    static int N;
    static String answer = "";

    static void dfs(String tmp){
        if(answer != "") return;

        if(tmp.length() == N){
            answer = tmp;
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(check(tmp + i)) dfs(tmp + i);
        }

    }

    static boolean check(String str){
        for(int i = 1; i <= str.length() / 2; i++){
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i);
            if(front.equals(back)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());

         dfs("");

         System.out.println(answer);

    }
}
