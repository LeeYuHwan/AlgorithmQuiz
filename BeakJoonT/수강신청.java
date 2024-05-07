import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Q13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new LinkedHashSet<>();
        for (int i = 0; i < l; i++){
            String student = br.readLine();

            hs.remove(student);
            hs.add(student);
        }

        int idx = 0;
        for (String student : hs) {
            if(idx >= k) break;
            System.out.println(student);
            idx++;
        }
    }
}
