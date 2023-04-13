import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> al = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int l = Integer.parseInt(st.nextToken());
            al.add(l);
        }

        Collections.sort(al);

        int answer = 0;
        while (al.size() > 1){

            al.set(0, al.get(0) - 1);
            if(al.get(0) == 0) al.remove(0);

            al.remove(al.size() - 1);

            answer++;
        }

        System.out.println(answer);

    }
}
