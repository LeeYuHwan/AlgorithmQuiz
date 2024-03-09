class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0, idx2 = 0;

        String answer = "Yes";
        for (int i = 0; i < goal.length; i++){

            boolean sw = false;

            if(idx1 < cards1.length && goal[i].equals(cards1[idx1])) {
                idx1++;
                sw = true;
            }
            if(idx2 < cards2.length && goal[i].equals(cards2[idx2])) {
                idx2++;
                sw = true;
            }

            if(!sw) {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}