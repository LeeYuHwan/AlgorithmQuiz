import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        if(N == 1){
            for(int i = 1; i < K; i++){
                if(arr[i] != arr[i - 1]){
                    answer++;
                }
            }
        }
        else {
            HashSet<Integer> hs = new HashSet<>();

            for(int i = 0; i < K; i++) {
                if(hs.contains(arr[i])) continue;

                if(hs.size() < N){
                    hs.add(arr[i]);
                }
                else{
                    HashSet<Integer> tmpHs = new HashSet<>(hs);

                    for(int j = i + 1; j < K; j++){
                        if(tmpHs.contains(arr[j])){
                            tmpHs.remove(arr[j]);
                        }

                        if(tmpHs.size() < 2) break;

                    }

                    hs.remove(tmpHs.iterator().next());
                    hs.add(arr[i]);
                    answer++;

                }

            }

        }

        System.out.println(answer);

    }
}
