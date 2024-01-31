import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < name.length; i++) hm.put(name[i], yearning[i]);

        int[] answer = new int[photo.length];

        for(int i = 0; i < photo.length; i++){

            int score = 0;

            for (int j = 0; j < photo[i].length; j++) if (hm.get(photo[i][j]) != null) score += hm.get(photo[i][j]);

            answer[i] = score;
        }

        return answer;

    }
}