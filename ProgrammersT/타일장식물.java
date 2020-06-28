class Solution {
    public long solution(int n) {     long[] tmp = new long[n];
   tmp[0] = 1;
   tmp[1] = 1;
   tmp[2] = tmp[0] + tmp[1];
   
   for(int i = 3; i < n; i++){
     tmp[i] = tmp[i-1] + tmp[i-2];
   }
   
   long answer = (tmp[n-1]*2) + ((tmp[n-1] + tmp[n-2])*2);
        return answer;
    }
}