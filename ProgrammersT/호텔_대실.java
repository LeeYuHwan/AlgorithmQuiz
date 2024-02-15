class Solution {
    public int solution(String[][] book_time) {
        int[] rooms = new int[(24 * 60) + 10];

        for (String[] time : book_time){
            int startTime = convertTime(time[0]);
            int endTime = convertTime(time[1]);

            rooms[startTime] += 1;
            rooms[endTime + 10] += -1;
        }

        int answer = 0;
        for (int i = 1; i < (24 * 60) + 10; i++){
            rooms[i] += rooms[i -1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

        static int convertTime(String time) {
        String[] str = time.split(":");
        return (Integer.parseInt(str[0]) * 60) + Integer.parseInt(str[1]);
    }

}