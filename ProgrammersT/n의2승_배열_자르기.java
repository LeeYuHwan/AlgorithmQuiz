class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int idx = 0;
        for (long i = left; i <= right; i++){
            long h = i / n + 1;
            long w = i % n + 1;

            answer[idx] = (int) Math.max(h, w);
            idx++;
        }

        return answer;
    }
}