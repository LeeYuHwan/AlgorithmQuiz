
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int currentIdx = 0;

        for (int sec : section){
            if (sec > currentIdx) {
                answer++;
                currentIdx = sec + m - 1;
            }
        }

        return answer;
    }
}