import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) { 
        HashMap<String, Integer> idxMap = new HashMap<>();
        int[][] arr = new int[friends.length][friends.length];
        int[] arrCnt = new int[friends.length];

        for (int i = 0; i < friends.length; i++) idxMap.put(friends[i], i);

        for (String gift : gifts){
            String[] str = gift.split(" ");
            arr[idxMap.get(str[0])][idxMap.get(str[1])]++;
        }

        for (int i = 0; i < arr.length; i++){
            int give = 0;
            int receive = 0;
            for (int j = 0; j < arr[i].length; j++){
                give += arr[i][j];
                receive += arr[j][i];
            }

            arrCnt[i] = give - receive;
        }

        int answer = 0;

        for (int i = 0; i < arr.length; i++){
            int sum = 0;

            for (int j = 0; j < arr[i].length; j++){
                int give = arr[i][j];
                int receive = arr[j][i];

                if (receive < give) sum++;
                else if (receive == give && arrCnt[j] < arrCnt[i]) sum++;

            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }
}