import java.util.*;

class Pair2 {
    String name;
    int start;
    int playTime;

    public Pair2(String name, int start, int playTime){
        this.name = name;
        this.start = start;
        this.playTime = playTime;
    }
}

class Solution {
    public String[] solution(String[][] plans) { 
        Pair2[] plansArr = new Pair2[plans.length];
        for(int i = 0; i < plans.length; i++) {

            String[] tmpStr = plans[i][1].split(":");
            int startTime = (Integer.parseInt(tmpStr[0]) * 60) + Integer.parseInt(tmpStr[1]);

            plansArr[i] = new Pair2(plans[i][0], startTime, Integer.parseInt(plans[i][2]));
        }
        Arrays.sort(plansArr, Comparator.comparingInt(a -> a.start));

        Stack<Pair2> stk = new Stack<>();
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < plansArr.length - 1; i++){
            Pair2 curP = plansArr[i];
            Pair2 nextP = plansArr[i + 1];

            if((curP.start + curP.playTime) > nextP.start) {
                curP.playTime = (curP.start + curP.playTime) - nextP.start;
                stk.push(curP);
            }
            else{
                answer.add(curP.name);

                int gapTime = nextP.start - (curP.start + curP.playTime);

                while (gapTime > 0 && !stk.isEmpty()){
                    Pair2 stkPair = stk.pop();

                    int timeDiff = stkPair.playTime - gapTime;

                    stkPair.playTime = timeDiff;
                    gapTime = timeDiff * -1;

                    if (timeDiff > 0) {
                        stk.push(stkPair);
                        break;
                    }

                    answer.add(stkPair.name);
                }
            }
        }

        answer.add(plansArr[plansArr.length - 1].name);
        while (!stk.isEmpty()) answer.add(stk.pop().name);
        return answer.toArray(new String[0]);
    }
}