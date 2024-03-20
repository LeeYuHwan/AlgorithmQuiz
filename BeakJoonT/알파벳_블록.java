import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Q27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Deque<Character> deque = new ArrayDeque<>();
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n != 3) {
                if(n == 1) {
                    deque.addLast(st.nextToken().charAt(0));
                    stk.push(1);
                }
                else {
                    deque.addFirst(st.nextToken().charAt(0));
                    stk.push(2);
                }
            } else {
                if(!stk.isEmpty() && !deque.isEmpty()) {
                    int task = stk.pop();

                    if(task == 1) deque.pollLast();
                    else deque.pollFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        if(sb.length() == 0) System.out.println(0);
        else System.out.println(sb);
    }
}
