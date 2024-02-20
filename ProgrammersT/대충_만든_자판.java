class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++){
            for (int j = 0; j < targets[i].length(); j++){
                int cnt = 102;

                for (int idx = 0; idx < keymap.length; idx++) if(keymap[idx].contains("" + targets[i].charAt(j))) cnt = Math.min(cnt, keymap[idx].indexOf(""+targets[i].charAt(j)) + 1);

                if(cnt != 102) answer[i] += cnt;
                else {
                    answer[i] = -1;
                    break;
                }
            }

            if (answer[i] == 0) answer[i] = -1;
        }


        return answer;
    }
}