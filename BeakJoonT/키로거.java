import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class Q5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            String L = br.readLine();

            Stack<Character> stk = new Stack<>();
            Stack<Character> moveStk = new Stack<>();

            for (int i = 0; i < L.length(); i++){
                if(L.charAt(i) == '<') {
                    if (!stk.isEmpty()) moveStk.push(stk.pop());
                }
                else if (L.charAt(i) == '>') {
                    if (!moveStk.isEmpty()) stk.push(moveStk.pop());
                }
                else if (L.charAt(i) == '-') {
                    if (!stk.isEmpty()) stk.pop();
                }
                else {
                    stk.push(L.charAt(i));
                }
            }

            while (!moveStk.isEmpty()) stk.push(moveStk.pop());
            for (int i = 0; i < stk.size(); i++) bw.write(stk.get(i));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
