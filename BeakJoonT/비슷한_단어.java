import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> al = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            al.add(str);
        }

        int max = -1;

        int left = N;
        int right = N;

        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(al.get(i) == al.get(j)) continue;

                int size = Math.min(al.get(i).length(), al.get(j).length());
                int tmp = 0;
                if(size == al.get(i).length()){
                    for(int z = 0; z < al.get(i).length(); z++){
                        if(al.get(i).charAt(z) != al.get(j).charAt(z)) break;
                        tmp++;
                    }
                }
                else if(size == al.get(j).length()){
                    for(int z = 0; z < al.get(j).length(); z++){
                        if(al.get(i).charAt(z) != al.get(j).charAt(z)) break;
                        tmp++;
                    }
                }

                if(tmp > max) {
                    max = tmp;
                    left = i;
                    right = j;
                }
            }
        }

        int s = Math.min(left, right);
        int b = Math.max(left, right);

        System.out.println(al.get(s));
        System.out.println(al.get(b));
    }
}
