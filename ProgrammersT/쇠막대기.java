class Solution {
    public int solution(String arrangement) {
        int stick = 0;
        int answer = 0;

        for(int i = 0 ; i < arrangement.length(); i++) {
            if(arrangement.charAt(i) == '(') {
                stick++;
            }
            if(i == 0) {                                
                if(arrangement.charAt(i) == ')') {
                    stick--;
                    answer += stick;
                }

            }
            else {                              
                if(arrangement.charAt(i - 1) == '(') {                  
                    if(arrangement.charAt(i) == ')') {
                        stick--;
                        answer += stick;
                    }
                }
                else if(arrangement.charAt(i - 1) == ')') {                 
                    if(arrangement.charAt(i) == ')') {
                        stick--;
                        answer += 1;
                    }
                }

            }

        }
        return answer;
    }
}