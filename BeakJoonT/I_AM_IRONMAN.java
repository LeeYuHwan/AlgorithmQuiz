import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q17264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int point = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String result = st.nextToken();

            if(result.equals("W")) map.put(name, w);
            else map.put(name, -l);
        }

        boolean sw = false;
        for (int i = 0; i < n; i++){
            String partner = br.readLine();

            if(!map.containsKey(partner)) point -= l;
            else point += map.get(partner);

            if(point < 0) point = 0;
            if(point >= goal) {
                sw = true;
                break;
            }
        }

        if(sw) System.out.println("I AM NOT IRONMAN!!");
        else System.out.println("I AM IRONMAN!!");

    }
}
