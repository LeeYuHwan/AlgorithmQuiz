import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;

        int cnt = 1;
        for (int fruit : arr){
            if(cnt == m){
                answer += fruit * m;
                cnt = 0;
            }

            cnt++;
        }

        return answer;
    }
}