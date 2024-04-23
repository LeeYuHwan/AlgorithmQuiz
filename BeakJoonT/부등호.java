import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2529 {

    static int k;
    static String[] arr;
    static boolean[] visited = new boolean[10];
    static List<String> ansList = new ArrayList<>();

    static boolean check(char sign, int beforeNum, int CurrentNum){
        if(sign == '>' && beforeNum > CurrentNum) return true;
        else if(sign == '<' && beforeNum < CurrentNum) return true;

        return false;
    }

    static void dfs(int beforeNum, int idx, String sum){
        if(idx == k + 1) {
            ansList.add(sum);
            return;
        }

        for (int i = 0; i < 10; i++){
            if(!visited[i]){
                if(idx == 0 || check(arr[idx - 1].charAt(0), beforeNum, i)) {
                    visited[i] = true;
                    dfs(i, idx + 1, sum + i);
                    visited[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        arr = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) arr[i] = st.nextToken();

        dfs(0, 0, "");
        Collections.sort(ansList);

        System.out.println(ansList.get(ansList.size() - 1));
        System.out.println(ansList.get(0));
        
    }
}
