class Solution {
    static int answer = 0;

    static void dfs(int cnt, int sum, int depth, int[] nums){
        if (cnt == 3) {
            if (isPrime(sum)) answer++;
        }
        else {
            for (int i = depth; i < nums.length; i++){
                dfs(cnt + 1, sum + nums[i], i + 1, nums);
            }
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= (int)Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    public int solution(int[] nums) {
        dfs(0, 0, 0, nums);
        return answer;
    }
}