import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer> al = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            al.add(Integer.parseInt(st.nextToken()));
        }

        int tmp = 0;
        for(int i = 0; i < x; i++){
            tmp += al.get(i);
        }

        int answer = tmp;
        int cnt = 1;

        for(int i = x; i < n; i++){
            tmp += al.get(i) - al.get( i - x );

            if(tmp == answer) cnt++;
            else if(tmp > answer){
                answer = tmp;
                cnt = 1;
            }

        }

        if(answer == 0) {
            System.out.println("SAD");
        }
        else{
            System.out.println(answer);
            System.out.println(cnt);
        }

    }
}
