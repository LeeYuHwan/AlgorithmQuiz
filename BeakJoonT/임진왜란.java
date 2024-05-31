import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q3077 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Map<String, Integer> hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            hm.put(st.nextToken(), i);
        }

        String[] arr = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = st.nextToken();
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++) {
                if(hm.get(arr[i]) < hm.get(arr[j])) answer++;
            }
        }

        System.out.println(answer + "/" + (n * (n - 1) / 2));
    }
}
