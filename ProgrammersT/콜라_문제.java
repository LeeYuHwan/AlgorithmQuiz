class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n / a > 0) {
            answer += ((n / a) * b);

            if(n % a == 0) n -= (n - ((n / a) * b));
            else n -= (n - (((n / a) * b) + (n % a)));
        }

        return answer;
    }
}