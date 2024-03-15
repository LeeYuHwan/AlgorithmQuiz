class Solution {

    static boolean isPrime(long n) {
        for (long i = 2; i <= (long)Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public int solution(int n, int k) {
        String str = Long.toString(n, k);
        String[] arr = str.split("0");

        int answer = 0;

        for (String tmp : arr){
            if(!tmp.equals("1") && !tmp.equals("") && isPrime(Long.parseLong(tmp))) answer++;
        }

        return answer;
    }
}