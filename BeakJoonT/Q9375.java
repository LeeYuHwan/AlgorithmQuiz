import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            int answer = 1;
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                if(map.containsKey(kind)) map.put(kind, map.get(kind) + 1);
                else map.put(kind, 1);
            }

            for (int item : map.values()) answer *= (item + 1);
            System.out.println(answer - 1);
        }
    }
}
