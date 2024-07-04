import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();

            x = x.substring(0, x.length() - 1);
            x = x.substring(1);
            String[] numbers = x.split(",");

            for (int i = 0; i < numbers.length; i++) {
                if(!numbers[i].equals("")) deque.addLast(Integer.parseInt(numbers[i]));
            }

            StringBuilder s = new StringBuilder();
            boolean reverseSw = false;
            for (int i = 0; i < p.length(); i++){
                char task = p.charAt(i);

                if(task == 'R') reverseSw = !reverseSw;
                else {
                    if(deque.isEmpty()) {
                        s.append("error");
                        break;
                    }

                    if(reverseSw) deque.pollLast();
                    else deque.pollFirst();
                }
            }

            if(s.length() == 0) {
                s.append('[');
                while (!deque.isEmpty()){
                    if(reverseSw) s.append(deque.pollLast());
                    else s.append(deque.pollFirst());

                    if(!deque.isEmpty()) s.append(',');
                }
                s.append(']');
            }

            System.out.println(s);

            deque.clear();
        }

    }
}
