class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] moveH = {-1, 1, 0, 0};
        int[] moveW = {0, 0, -1, 1};

        String currentColor = board[h][w];
        int answer = 0;

        for (int i = 0; i < 4; i++){
            int tmpH = h + moveH[i];
            int tmpW = w + moveW[i];

            if(tmpH < 0 || tmpW < 0 || tmpH >= board.length || tmpW >= board[0].length || !currentColor.equals(board[tmpH][tmpW])) continue;
            answer++;
        }

        return answer;
    }
}