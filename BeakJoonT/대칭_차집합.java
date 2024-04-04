import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] A = new int[a];
        int[] B = new int[b];

        HashSet<Integer> aHs = new HashSet<>();
        HashSet<Integer> bHs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            aHs.add(A[i]);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            bHs.add(B[i]);
        }

        for (int i = 0; i < a; i++) bHs.remove(A[i]);
        for (int i = 0; i < b; i++) aHs.remove(B[i]);

        System.out.println(aHs.size() + bHs.size());
    }
}