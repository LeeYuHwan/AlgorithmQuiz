import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> oldMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) oldMap.put(want[i], number[i]);

        for (int i = 0; i < discount.length; i++){

            Map<String, Integer> copyMap = new HashMap<>(oldMap);

            if(discount.length - i - 10 >= 0){
                int idx = i, cnt = 0;
                while (cnt < 10){
                    if(copyMap.get(discount[idx]) != null){
                        int tmp = copyMap.get(discount[idx]);
                        tmp--;

                        if(tmp == 0) copyMap.remove(discount[idx]);
                        else copyMap.put(discount[idx], tmp);
                    }

                    idx++;
                    cnt++;
                }
            }

            if(copyMap.size() == 0) answer++;
        }

        return answer;
    }
}