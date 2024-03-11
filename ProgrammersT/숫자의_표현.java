class Solution {

    static int answer = 0;

    static void dfs(int n, int cnt, int sum){
        if (sum >= n) {
            if(sum == n) answer++;

            return;
        }

        dfs(n, cnt + 1, sum + cnt);

    }

    public int solution(int n) {
        for (int i = 1 ; i <= n; i++) dfs(n, i, 0);
        return answer;
    }
}