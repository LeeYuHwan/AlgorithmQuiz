class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int cnt = 0;
        int idx = 0;
        int answer = health;
        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++){
            if(i == attacks[idx][0]) {
                answer -= attacks[idx][1];
                cnt = 0;

                idx++;
            }
            else if(answer < health) {
                answer += bandage[1];
                cnt++;

                if (cnt == bandage[0]) {
                    answer += bandage[2];
                    cnt = 0;
                }

                if(answer > health) answer = health;
            }

            if (idx > attacks.length - 1 || answer <= 0) break;
        }

        return answer > 0 ? answer : -1;
    }
}