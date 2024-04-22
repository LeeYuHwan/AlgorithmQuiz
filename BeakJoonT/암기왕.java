import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++){
            HashSet<Integer> hs = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n1; i++) hs.add(Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            int n2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n2; i++) {
                int number = Integer.parseInt(st.nextToken());

                if(hs.contains(number)) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
}
