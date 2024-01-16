class Solution {
    public int solution(String[] babbling) {
        String[] checkList = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (int i = 0; i < babbling.length; i++){
            String str = babbling[i];
            for(String check : checkList){
                str = str.replace(check, " ");
            }
            str = str.replace(" ", "");

            if(str.length() == 0) answer++;

        }

        return answer;
    }
}