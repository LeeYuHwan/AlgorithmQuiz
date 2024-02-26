class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++){
            int cnt = 0;
            boolean sw = false;

            for (int j = i - 1; j >= 0; j--){
                cnt++;
                if(s.charAt(i) == s.charAt(j)) {
                    sw = true;
                    break;
                }
            }

            if (sw) answer[i] = cnt;
            else answer[i] = -1;
        }

        return answer;
    }
}