import java.util.Map;

class Solution {
    public int solution(String s) {
        Map<String, Integer> map = Map.of(
                "zero", 0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );

        String tmp = "";
        String answer = "";
        for (int i = 0; i < s.length(); i++){

            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                answer += s.charAt(i);
                continue;
            }

            tmp += s.charAt(i);

            if(map.containsKey(tmp)) {
                answer += map.get(tmp);
                tmp = "";
            }
        }

        return Integer.parseInt(answer);
    }
}