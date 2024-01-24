class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int cnt = 1, h = 0, w = 0, sw = 0;

        while (cnt <= (n * n)){
            if(sw == 0){
                if(w < n && answer[h][w] == 0){
                    answer[h][w] = cnt;
                    w++;
                    cnt++;
                }
                else {
                    w--;
                    h++;
                    sw = 1;
                }
            }

            if(sw == 1){
                if(h < n && answer[h][w] == 0){
                    answer[h][w] = cnt;
                    h++;
                    cnt++;
                }
                else {
                    h--;
                    w--;
                    sw = 2;
                }
            }

            if(sw == 2){
                if(w >= 0 && answer[h][w] == 0){
                    answer[h][w] = cnt;
                    w--;
                    cnt++;
                }
                else {
                    w++;
                    h--;
                    sw = 3;
                }
            }

            if(sw == 3){
                if(h >= 0 && answer[h][w] == 0){
                    answer[h][w] = cnt;
                    h--;
                    cnt++;
                }
                else {
                    h++;
                    w++;
                    sw = 0;
                }
            }
        }

        return answer;
    }
}