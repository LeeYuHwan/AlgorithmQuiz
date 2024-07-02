import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        Stack<Long> stk = new Stack<>();
        for (int i = 0; i < n; i++){
            long h = Integer.parseInt(br.readLine());

            while (!stk.isEmpty()) {
                if(h < stk.peek()) break;
                else {
                    stk.pop();
                }
            }

            answer += stk.size();
            stk.push(h);
        }

        System.out.println(answer);
    }
}
