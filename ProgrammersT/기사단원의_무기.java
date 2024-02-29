import java.util.ArrayList;

class Solution {

    static int divisorSize(int num) {
        ArrayList<Integer> divisorList = new ArrayList<>();
        for (int i = 1; (i * i) <= num; i++) {
            if (num % i == 0) {
                divisorList.add(i);
                if (i != num / i) divisorList.add(num / i);
            }
        }
        return divisorList.size();
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++){
            int divisorSize = divisorSize(i);

            if (limit < divisorSize) answer += power;
            else answer += divisorSize;
        }

        return answer;
    }
}