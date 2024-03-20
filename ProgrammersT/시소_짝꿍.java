import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
         Arrays.sort(weights);

        HashMap<Double, Integer> hm = new HashMap<>();
        long answer = 0;

        for (int i = 0; i < weights.length; i++){

            double a = (double) weights[i] / 2;
            double b = ((double) weights[i] * 2) / 3;
            double c = ((double) weights[i] * 3) / 4;

            if (hm.containsKey((double) weights[i])) answer += hm.get((double) weights[i]);
            if (hm.containsKey(a)) answer += hm.get(a);
            if (hm.containsKey(b)) answer += hm.get(b);
            if (hm.containsKey(c)) answer += hm.get(c);

            hm.put((double) weights[i], hm.getOrDefault((double) weights[i], 0) + 1);
        }

        return answer;
    }
}