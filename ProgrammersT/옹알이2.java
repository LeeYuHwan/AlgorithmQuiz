class Solution {
    public int solution(String[] babbling) {
        String[] check1 = {"aya", "ye", "woo", "ma"};
        String[] check2 = {"ayaaya", "yeye", "woowoo", "mama"};

        int answer = 0;
        for (int i = 0; i < babbling.length; i++){
            String tmp = babbling[i];
            for (int j = 0; j < check1.length; j++) {
                tmp = tmp.replace(check2[j], "1").replace(check1[j], " ");
            }
            tmp = tmp.replace(" ", "");
            
            if (tmp.length() == 0) answer++;
        }

        return answer;
    }
}