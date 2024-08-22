import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Flower{
    int start;
    int end;

    public Flower(int startM, int startD, int endM, int endD){
        String startStr = "" + startD;
        String endStr = "" + endD;
        if(startD < 10) {
            startStr = "0" + startD;
        }
        if (endD < 10) {
            endStr = "0" + endD;
        }

        this.start = Integer.parseInt(startM + startStr);
        this.end = Integer.parseInt(endM + endStr);
    }
}

public class Q2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            list.add(new Flower(startM, startD, endM, endD));
        }

        list.sort((o1, o2) -> {
            if(o1.start == o2.start) return o2.end - o1.end;
            return o1.start - o2.start;
        });

        int limit = 1201;
        int startD = 301;
        int endD = 0;
        int answer = 0;
        int startIdx = 0;

        while (startD < limit) {
            boolean sw = false;

            for (int i = startIdx; i < N; i++){
                Flower flower = list.get(i);

                if(flower.start > startD) break;

                if (flower.end > endD) {
                    endD = flower.end;

                    startIdx = i + 1;
                    sw = true;
                }
            }

            if (sw) {
                startD = endD;
                answer++;
            }
            else break;
        }

        if(endD >= limit) System.out.println(answer);
        else System.out.println(0);

    }
}
