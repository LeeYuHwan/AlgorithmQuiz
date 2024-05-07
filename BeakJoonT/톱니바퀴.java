import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] gears = new String[4];

        for (int i = 0; i < 4; i++) gears[i] = br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int w = 0; w < k; w++ ) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int work = Integer.parseInt(st.nextToken());

            int[] works = new int[4];
            //1시계 -1반시계
            //1 * -1 = -1 // -1 * -1 = 1
            if(idx == 1) {
                if(gears[1].charAt(6) != gears[0].charAt(2)) {
                    works[1] = work * -1;
                    if(gears[2].charAt(6) != gears[1].charAt(2)) {
                        works[2] = work;
                        if(gears[3].charAt(6) != gears[2].charAt(2)) works[3] = work * -1;
                    }
                }
            }
            else if(idx == 2) {
                if(gears[0].charAt(2) != gears[1].charAt(6)) works[0] = work * -1;
                if(gears[2].charAt(6) != gears[1].charAt(2)) {
                    works[2] = work * -1;
                    if(gears[3].charAt(6) != gears[2].charAt(2)) works[3] = work;
                }
            }
            else if(idx == 3) {
                if(gears[3].charAt(6) != gears[2].charAt(2)) works[3] = work * -1;
                if(gears[1].charAt(2) != gears[2].charAt(6)) {
                    works[1] = work * -1;
                    if(gears[0].charAt(2) != gears[1].charAt(6)) works[0] = work;
                }

            }
            else {
                if(gears[2].charAt(2) != gears[3].charAt(6)) {
                    works[2] = work * -1;
                    if(gears[1].charAt(2) != gears[2].charAt(6)) {
                        works[1] = work;
                        if(gears[0].charAt(2) != gears[1].charAt(6)) works[0] = work * -1;
                    }
                }
            }
            works[idx - 1] = work;

            for (int i = 0; i < 4; i++){
                if(works[i] == 1) gears[i] = gears[i].charAt(gears[i].length() - 1) + gears[i].substring(0, gears[i].length() - 1);
                else if(works[i] == -1) gears[i] = gears[i].substring(1) + gears[i].charAt(0);
            }
        }

        int answer = 0;
        int cnt = 1;
        for (int i = 0; i < 4; i++){
            if(gears[i].charAt(0) - '0' == 1) answer += cnt;
            cnt *= 2;
        }

        System.out.println(answer);
    }
}
