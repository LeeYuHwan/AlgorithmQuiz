import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> stk = new Stack<>();

        int pass = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int student = Integer.parseInt(st.nextToken());

            if(student == pass) {
                pass++;
            }
            else {
                stk.push(student);
            }

            while (!stk.isEmpty()){
                if(stk.peek() == pass) {
                    stk.pop();
                    pass++;
                }
                else break;
            }
        }

        if(stk.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
