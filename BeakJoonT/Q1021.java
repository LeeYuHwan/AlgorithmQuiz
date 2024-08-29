import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int a = Integer.parseInt(st.nextToken());

            if(list.get(0) == a) {
                list.remove(0);
            }
            else {
                while (list.get(0) != a) {
                    int valueIdx = list.indexOf(a);
                    int size = list.size();

                    if((size / 2) < valueIdx) {
                        int preValue = list.get(size - 1);
                        list.remove(size - 1);
                        list.add(0, preValue);
                    }
                    else {
                        int preValue = list.get(0);
                        list.remove(0);
                        list.add(preValue);
                    }

                    answer++;
                }

                list.remove(0);
            }
        }

        System.out.println(answer);
    }
}
