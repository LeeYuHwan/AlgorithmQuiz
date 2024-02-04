class Solution {
    public int[] solution(String[] park, String[] routes) {

        int answerH = 0;
        int answerW = 0;

        for (int i = 0; i < park.length; i++){
            for (int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S') {
                    answerH = i;
                    answerW = j;
                    break;
                }
            }
        }

        for (String route : routes){
            String[] order = route.split(" ");

            int oldH = answerH;
            int oldW = answerW;

            for (int i = 0; i < Integer.parseInt(order[1]); i++){
                if(order[0].equals("N")){
                    answerH--;
                }
                else if(order[0].equals("S")){
                    answerH++;
                }
                else if(order[0].equals("W")){
                    answerW--;
                }
                else {
                    answerW++;
                }

                if(answerH < 0 || answerW < 0 || answerH >= park.length || answerW >= park[0].length() || park[answerH].charAt(answerW) == 'X') {
                    answerH = oldH;
                    answerW = oldW;

                    break;
                }
            }

        }

        int[] answer = {answerH, answerW};
        return answer;
    }
}