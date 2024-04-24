import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stick = br.readLine();

        int answer = 0;
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < stick.length(); i++){
            if(stick.charAt(i) == '(') stk.push('(');
            else {
                if(stick.charAt(i - 1) == '('){
                    stk.pop();
                    answer += stk.size();
                }
                else {
                    stk.pop();
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
