import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> hm = new HashMap<>();

        for (int val : tangerine) {
            if(hm.get(val) == null) hm.put(val, 1);
            else {
                int tmp = hm.get(val);
                hm.put(val, tmp + 1);
            }
        }

        List<Integer> keySet = new ArrayList<>(hm.keySet());
        keySet.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));

        for (int key : keySet) {
            if(k <= 0) break;

            k -= hm.get(key);
            answer++;
        }

        return answer;
    }
}