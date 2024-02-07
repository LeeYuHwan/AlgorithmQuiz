class Solution {
    public int solution(int[] ingredient) {
                int[] tmp = new int[ingredient.length];
        int answer = 0;

        int idx = 0;
        for (int val : ingredient){

            tmp[idx] = val;

            if(idx >= 3 && tmp[idx - 3] == 1 && tmp[idx - 2] == 2 && tmp[idx - 1] == 3 && tmp[idx] == 1) {
                idx -= 4;
                answer++;
            }

            idx++;
        }

        return answer;
    }
}