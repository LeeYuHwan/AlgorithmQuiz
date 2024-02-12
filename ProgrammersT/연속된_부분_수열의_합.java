class Solution {
    public int[] solution(int[] sequence, int k) {
	int startIdx = 0, endIdx = sequence.length - 1, sum = 0, left = 0, right = 0;

        while (left < sequence.length){
            while (right < sequence.length && sum < k) sum += sequence[right++];

            if(sum == k) {
                if ((endIdx - startIdx) > (right - left - 1)) {
                    startIdx = left;
                    endIdx = right - 1;
                }
            }

            sum -= sequence[left++];
        }

        int[] answer = {startIdx, endIdx};
        return answer;
    }
}