import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair8{
    int first;
    int second;

    public Pair8(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Q14658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Pair8> al = new ArrayList<>();

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            al.add(new Pair8(x, y));
        }

        int answer = -1;

        for(Pair8 pair1 : al){
            for(Pair8 pair2 : al){
                int cnt = 0;
                for(Pair8 pair3 : al){
                    if(pair1.first <= pair3.first && pair3.first <= (pair1.first + L) && pair2.second <= pair3.second && pair3.second <= (pair2.second + L)) cnt++;
                }
                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(K - answer);

    }
}
