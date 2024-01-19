import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();

        for(String term : terms){
            String[] tmp = term.split(" ");
            termsMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        String todayTmp[] = today.split("\\.");

        int todayYear = Integer.parseInt(todayTmp[0]);
        int todayMonth = Integer.parseInt(todayTmp[1]);
        int todayDay = Integer.parseInt(todayTmp[2]);

        int idx = 0;
        for(String privacy : privacies){
            idx++;
            String[] privacyTmp = privacy.split(" ");

            String[] joinTmp = privacyTmp[0].split("\\.");
            int joinYear = Integer.parseInt(joinTmp[0]);
            int joinMonth = Integer.parseInt(joinTmp[1]);
            int joinDay = Integer.parseInt(joinTmp[2]);

            int limitDay = termsMap.get(privacyTmp[1]) * 28;
            int comparisonNumber = ((todayYear - joinYear) * 12 * 28) + ((todayMonth - joinMonth) * 28) + (todayDay - joinDay);

            if(comparisonNumber >= limitDay){
                answerList.add(idx);
            }

        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}