import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) sequence[i] = Integer.parseInt(br.readLine());

        List<Character> list = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();

        int idx = 0;
        for (int i = 1; i <= n; i++){
            list.add('+');
            stk.push(i);

            while (!stk.isEmpty() && sequence[idx] == stk.peek()){
                list.add('-');
                stk.pop();
                idx++;
            }
        }

        if(stk.isEmpty()) for (char ans : list) System.out.println(ans);
        else System.out.println("NO");
    }
}
