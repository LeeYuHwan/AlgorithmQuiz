class Solution {

    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int a = arrayA[0];
        int b = arrayB[0];

        for (int i = 1; i < arrayA.length; i++){
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }

        for (int i = 0; i < arrayA.length; i++){
            if(b > 0 && arrayA[i] % b == 0) b = 0;
            if(a > 0 && arrayB[i] % a == 0) a = 0;
        }

        int answer = Math.max(a, b);
        return answer;
    }
}