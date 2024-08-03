import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if(str.equals("*")) break;

            int cnt = 1;
            boolean sw = true;
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder();
                HashSet<String> hs = new HashSet<>();

                for (int j = 0; (j + cnt) < str.length(); j++){
                    sb.append(str.charAt(j));
                    sb.append(str.charAt(j + cnt));

                    if(hs.contains(sb.toString())){
                       sw = false;
                       break;
                    }
                    else hs.add(sb.toString());

                    sb.setLength(0);
                }
                if(!sw) break;

                cnt++;
            }

            if(sw) System.out.println(str + " is surprising.");
            else System.out.println(str + " is NOT surprising.");
        }
    }
}
