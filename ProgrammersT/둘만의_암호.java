import java.util.HashSet;

class Solution {
    public String solution(String s, String skip, int index) {

        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < skip.length(); i++) hs.add(skip.charAt(i));

        String answer = "";

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            int cnt = 0;
            int idx = 0;
            while (true){
                char tmp = (char) (c + idx);

                if(tmp > 122) {
                    c = 97;
                    tmp = 97;
                    idx = 0;
                }

                if (hs.contains(tmp)){
                    idx++;
                }
                else {
                    idx++;
                    cnt++;

                    if(cnt > index) {
                        c = tmp;
                        break;
                    }

                }

            }

            answer += c;
        }

        return answer;
    }
}