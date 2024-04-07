class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 1;

        for (int station : stations) {
            if((station - w) > idx) {
                answer += ((station - w) - idx) / ((w * 2) + 1);
                if((((station - w) - idx) % ((w * 2) + 1)) != 0) answer++;
            }
            idx = station + w + 1;
        }

        if((idx - 1) < n) {
            answer += ((n - (idx - 1)) / ((w * 2) + 1));
            if(((n - (idx - 1)) % ((w * 2) + 1)) != 0) answer++;
        }

        return answer;
    }
}