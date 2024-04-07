import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        int AIdx = 0, BIdx = 0;
        while (AIdx < A.length && BIdx < B.length) {

            if(B[BIdx] > A[AIdx]) {
                answer++;

                AIdx++;
                BIdx++;
            }
            else BIdx++;
        }


        return answer;
    }
}