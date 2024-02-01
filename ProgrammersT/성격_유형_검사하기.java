import java.util.HashMap;
import java.util.Map;


class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        Map<Character, Integer> hm = new HashMap<>() {{
            put('R', 0);
            put('T', 0);
            put('C', 0);
            put('F', 0);
            put('J', 0);
            put('M', 0);
            put('A', 0);
            put('N', 0);
        }};

        for(int i = 0; i < survey.length; i++){

            int score = 0;

            if(choices[i] == 1 || choices[i] == 7){
                score = 3;
            }
            else if(choices[i] == 2 || choices[i] == 6){
                score = 2;
            }
            else if(choices[i] == 3 || choices[i] == 5){
                score = 1;
            }

            if(choices[i] < 4){
                int tmpScore = hm.get(survey[i].charAt(0));
                tmpScore += score;

                hm.put(survey[i].charAt(0), tmpScore);
            }
            else {
                int tmpScore = hm.get(survey[i].charAt(1));
                tmpScore += score;

                hm.put(survey[i].charAt(1), tmpScore);
            }

        }

        String answer = "";

        for(int i = 0; i < types.length; i++){
            if(hm.get(types[i][0]) < hm.get(types[i][1])) answer += types[i][1];
            else answer += types[i][0];
        }

        return answer;
    }
}