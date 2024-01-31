import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10775 {

    static int[] airport;

    static int find(int x){
        if(x == airport[x]) return x;
        return airport[x] = find(airport[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        airport[a] = b;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        airport = new int[G + 1];

        for(int i = 1; i <= G; i++) airport[i] = i;

        int answer = 0;

        for(int idx = 0; idx < P; idx++){

            int plane = Integer.parseInt(br.readLine());
            if(find(plane) == 0) break;

            answer++;
            union(find(plane), find(plane) - 1);

        }

        System.out.println(answer);

    }
}
