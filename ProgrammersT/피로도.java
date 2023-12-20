class Solution {
    static boolean[] visit;
    static int answer = 0;

    static void dfs(int[][] dungeons, int k, int cnt){
        for(int i = 0; i < dungeons.length; i++){
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                dfs(dungeons, k - dungeons[i][1], cnt + 1);
                visit[i] = false;
            }
        }

        answer = Math.max(answer, cnt);

    }

    public int solution(int k, int[][] dungeons) {

        visit = new boolean[dungeons.length + 1];

        dfs(dungeons,k, 0);

        return answer;
    }
}