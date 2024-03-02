mport java.util.ArrayList;

class Solution {
    static int[] inDegree = new int[1000001];
    static int[] outDegree = new int[1000001];
    static boolean[] visited = new boolean[1000001];
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();

    static int[] answer = new int[4];

    static void dfs(int node) {
        if (visited[node]) {
            answer[1]++;
            return;
        }

        if (outDegree[node] == 0) {
            answer[2]++;
            return;
        }

        if (outDegree[node] == 2) {
            answer[3]++;
            return;
        }

        visited[node] = true;

        for (int n : al.get(node)) dfs(n);

    }

    public int[] solution(int[][] edges) {

        for (int i = 0; i < 1000001; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            al.add(tmp);
        }

        for (int[] edge : edges){
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;

            al.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < 1000001; i++) {
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                answer[0] = i;
                break;
            }
        }

        for (int n : al.get(answer[0])) dfs(n);

        return answer;
    }
}