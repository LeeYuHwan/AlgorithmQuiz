import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0){

            String W = br.readLine();

            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            if(K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alphaArr = new int[26];

            for(int i = 0; i < W.length(); i++){
                alphaArr[W.charAt(i) - 'a']++;
            }

            int max = -1;
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < W.length() - 1; i++){

                if(alphaArr[W.charAt(i) - 'a'] < K) continue;

                int cnt = 1;
                for(int j = i + 1; j < W.length(); j++){
                    if(W.charAt(i) == W.charAt(j)) cnt++;
                    if(cnt == K) {
                        max = Math.max(max, j - i + 1);
                        min = Math.min(min, j - i + 1);
                        break;
                    }
                }
            }

            if(max == -1 && min == Integer.MAX_VALUE) System.out.println("-1");
            else System.out.println(min + " " + max);
        }

    }
}
