import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        Stack<Integer> lStk = new Stack<>();
        Stack<Integer> mStk = new Stack<>();

        int cnt = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                cnt--;

                int mulNum = str.charAt(i - 1) - '0';

                lStk.add(cnt);
                mStk.add(mulNum);

                cnt = 0;
            }
            else if (str.charAt(i) == ')'){
                int val = mStk.peek();
                mStk.pop();

                val *= cnt;

                int plus = lStk.peek();
                lStk.pop();

                cnt = plus + val;

            }
            else cnt++;
        }

        System.out.println(cnt);

    }
}
