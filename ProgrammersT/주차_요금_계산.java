import java.util.HashMap;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> parkingMap = new HashMap<>();
        TreeMap<String, Integer> chargeMap = new TreeMap<>();

        for (String record : records){
            String[] arr = record.split(" ");

            String[] times = arr[0].split(":");

            int time = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);

            if(arr[2].equals("IN")) parkingMap.put(arr[1], time);
            if(arr[2].equals("OUT")) {
                int inTime = parkingMap.get(arr[1]);
                int chargeTime = 0;
                if(chargeMap.containsKey(arr[1])) chargeTime = (time - inTime + chargeMap.get(arr[1]));
                else chargeTime = time - inTime;

                chargeMap.put(arr[1], chargeTime);
                parkingMap.remove(arr[1]);
            }
        }

        for (String key: parkingMap.keySet()) {
            int inTime = parkingMap.get(key);

            if(chargeMap.get(key) != null){
                int time = chargeMap.get(key);

                time += (((23 * 60) + 59) - inTime);
                chargeMap.put(key, time);
            }
            else chargeMap.put(key, ((23 * 60) + 59) - inTime);
        }

        int idx = 0;
        int[] answer = new int[chargeMap.size()];
        for (String key: chargeMap.keySet()) {
            int parkingTime = chargeMap.get(key);

            if(parkingTime <= fees[0]) {
                answer[idx] = fees[1];
            }
            else{
                if((parkingTime - fees[0]) % fees[2] != 0) parkingTime += (fees[2] - ((parkingTime - fees[0]) % fees[2]));
                answer[idx] = fees[1] + ((parkingTime - fees[0]) / fees[2]) * fees[3];
            }

            idx++;
        }


        return answer;
    }
}