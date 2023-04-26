import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q25381 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Queue<Integer> q = new LinkedList<>();

        int answer = 0;
        boolean[] visit = new boolean[S.length() + 1];

        for(int i = 0; i < S.length(); i++){

            if(S.charAt(i) == 'B') q.add(i);
            else if (S.charAt(i) == 'C' && !q.isEmpty()){
                visit[q.poll()] = true;
                answer++;
            }
        }

        int check = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == 'A') check++;
            else if (S.charAt(i) == 'B' && check > 0 && !visit[i]){
                visit[i] = true;
                check--;
                answer++;
            }
        }

        System.out.println(answer);

    }
}

