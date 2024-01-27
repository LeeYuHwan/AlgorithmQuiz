class Solution {
    public int solution(int[][] lines) {
        int[] totalLine = new int[201];

        for(int i = 0; i < lines.length; i++){

            int start = lines[i][0] + 100;
            int end = lines[i][1] + 100;

            for (int j = start; j < end; j++){
                totalLine[j]++;
            }
        }

        int answer = 0;

        for (int i = 0; i < totalLine.length; i++){
            if(totalLine[i] > 1) answer++;
        }

        return answer;
    }
}