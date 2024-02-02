import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("code", 0);
        hm.put("date", 1);
        hm.put("maximum", 2);
        hm.put("remain", 3);

        int extIdx = hm.get(ext);
        int sortIdx = hm.get(sort_by);

        int[][] answer = Arrays.stream(data).filter(arr -> arr[extIdx] < val_ext).toArray(int[][]::new);
        Arrays.sort(answer, (Comparator.comparingInt(o -> o[sortIdx])));

        return answer;
    }
}