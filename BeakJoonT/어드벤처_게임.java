import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2310 {

    static boolean[] visit;
    static char[] room;
    static int[] fee;

    static ArrayList<ArrayList<Integer>> al;
    static int n;
    static boolean flag;

    static void dfs(int node, int money){

        if(flag) return;

        if(node == n) {
            flag = true;
            return;
        }

        for(int i = 0; i < al.get(node - 1).size(); i++){

            int next = al.get(node - 1).get(i);

            if(visit[next]) continue;

            if(room[next] == 'L' && money < fee[next]) {
                money = fee[next];
            }
            else if(room[next] == 'T'){
                money -= fee[next];
                if(money < 0) return;
            }

            visit[next] = true;
            dfs(next, money);
            visit[next] = false;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            room = new char[n + 1];
            fee = new int[n + 1];
            visit = new boolean[n + 1];
            flag = false;

            al = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
                room[i] = st.nextToken().charAt(0);
                fee[i] = Integer.parseInt(st.nextToken());

                ArrayList<Integer> tmp = new ArrayList<>();
                while (true){
                    int node = Integer.parseInt(st.nextToken());
                    if(node == 0) break;
                    tmp.add(node);
                }

                al.add(tmp);
            }

            dfs(1, fee[1]);

            if(flag) System.out.println("Yes");
            else System.out.println("No");
        }


    }
}
