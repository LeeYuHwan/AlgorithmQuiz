import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
                HashMap<String, ArrayList<String>> reporter = new HashMap<>();
        HashMap<String, Integer> reportedCnt = new HashMap<>();

        for (String id : id_list) {
            reporter.put(id, new ArrayList<>());
            reportedCnt.put(id, 0);
        }

        for (String reports : report){
            String[] tmpArr = reports.split(" ");

            ArrayList<String> al = reporter.get(tmpArr[0]);

            if (!al.contains(tmpArr[1])){
                al.add(tmpArr[1]);

                reporter.put(tmpArr[0], al);

                int cnt = reportedCnt.get(tmpArr[1]) + 1;
                reportedCnt.put(tmpArr[1], cnt);
            }

        }

        int[] answer = new int[id_list.length];

        for(int i = 0; i < id_list.length; i++){

            ArrayList<String> al = reporter.get(id_list[i]);

            for (String reported : al) {
                int cnt = reportedCnt.get(reported);
                if (cnt >= k) answer[i]++;
            }

        }

        return answer;
    }
}