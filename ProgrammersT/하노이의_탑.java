mport java.util.ArrayList;

class Solution {


    static ArrayList<int []> al;

    static void dfs(int from, int by, int to, int n){
        if(n == 1) al.add(new int[] {from, to});
        else {
            dfs(from, to, by, n - 1);
            al.add(new int[] {from, to});
            dfs(by, from, to, n - 1);
        }
    }

    public int[][] solution(int n) {
        al = new ArrayList<>();
        dfs(1, 2, 3, n);

        int[][] answer = new int[al.size()][2];

        for (int i = 0; i < al.size(); i++) answer[i] = al.get(i);
        return answer;
    }
}