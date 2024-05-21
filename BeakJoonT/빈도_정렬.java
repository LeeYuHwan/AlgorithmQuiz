import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> hm = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int value = Integer.parseInt(st.nextToken());

            if(hm.containsKey(value)) {
                int cnt = hm.get(value);
                cnt++;
                hm.put(value, cnt);
            }
            else hm.put(value, 1);
        }

        List<Integer> keySet = new ArrayList<>(hm.keySet());
        keySet.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));

        for (int key : keySet) {
            for (int i = 0; i < hm.get(key); i++) System.out.print(key + " ");
        }

    }
}
