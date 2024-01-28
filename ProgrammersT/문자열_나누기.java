import java.util.ArrayList;

class Solution {
    public int solution(String s) {

        char x = s.charAt(0);
        int xNum = 1, yNum = 0;

        String tmp = x + "";

        ArrayList<String> al = new ArrayList<>();

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != x) yNum++;
            else xNum++;

            tmp += s.charAt(i);

            if(xNum == yNum) {
                al.add(tmp);
                tmp = "";

                if(i < s.length() - 1) {
                    x = s.charAt(i + 1);
                    tmp = x + "";
                    xNum = 1;
                    yNum = 0;
                    i++;
                }

            }
        }

        int answer = 0;

        if(tmp.length() != 0) answer = al.size() + 1;
        else answer = al.size();

        return answer;
    }
}