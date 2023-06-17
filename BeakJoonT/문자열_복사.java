import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int answer = 0;

        int idx = 0;
        while (idx < P.length()){
            int max = 0;

            for(int i = 0; i < S.length(); i++){
                int tmp = 0;

                while (S.charAt(i + tmp) == P.charAt(idx + tmp)){
                    tmp++;

                    if((i + tmp) >= S.length() || (idx + tmp) >= P.length()) break;
                }

                if(max < tmp) max = tmp;
            }

            idx += max;
            answer++;
        }

        System.out.println(answer);

    }
}
