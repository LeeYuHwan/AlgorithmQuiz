class Solution {
    public int solution(int[][] board) {
        int[] moveH = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] moveW = {0, 0, -1, 1, -1, 1, -1, 1};

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){

                    board[i][j] = 2;

                    for(int idx = 0; idx < 8; idx++){
                        int tmpH = i + moveH[idx];
                        int tmpW = j + moveW[idx];

                        if(tmpH < 0 || tmpH >= board.length || tmpW < 0 || tmpW >= board[i].length || board[tmpH][tmpW] == 1) continue;

                        board[tmpH][tmpW] = 2;

                    }

                }
            }
        }

        int answer = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    answer++;
                }
            }
        }

        return answer;
    }
}