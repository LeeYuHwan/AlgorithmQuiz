import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Long, Long> hm = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++){
            long value = Integer.parseInt(st.nextToken());

            if(hm.containsKey(value)) {
                long tmp = hm.get(value);
                tmp++;
                hm.put(value, tmp);
            }
            else hm.put(value, 1L);
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            long value = Integer.parseInt(st.nextToken());

            if(!hm.containsKey(value)) sb.append("0 ");
            else sb.append(hm.get(value)).append(" ");
        }

        System.out.println(sb);
    }
}
