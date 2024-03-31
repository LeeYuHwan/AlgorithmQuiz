class Solution {

    static int answer = 0;

    static void dfs(int[] number, int idx, int sum, int cnt){
        if(cnt == 3) {
            if(sum == 0) answer++;
            return;
        }
        if(cnt > 3) return;

        for (int i = idx; i < number.length; i++){
            dfs(number, i + 1, sum + number[i], cnt + 1);
        }

    }

    public int solution(int[] number) {
        for (int i = 0; i < number.length; i++){
            dfs(number, i + 1, number[i], 1);
        }

        return answer;
    }
}