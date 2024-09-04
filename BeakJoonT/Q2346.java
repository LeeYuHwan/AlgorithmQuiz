import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Balloon {
    int idx;
    int order;
    public Balloon(int idx, int order) {
        this.idx = idx;
        this.order = order;
    }
}
public class Q2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Balloon> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));

        int idx = 0;
        for (int i = 0; i < N; i++){
            Balloon balloon = list.get(idx);
            System.out.print(balloon.idx + " ");

            list.remove(idx);
            if(list.size() == 0) break;

            if(balloon.order > 0) {
                idx--;
                idx += balloon.order;
                idx %= list.size();
            }
            if(balloon.order < 0) {
                for (int j = 0; j < Math.abs(balloon.order); j++){
                    idx--;
                    if(idx < 0) idx = list.size() - 1;
                }
            }

        }
    }
}
