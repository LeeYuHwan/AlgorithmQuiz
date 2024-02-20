import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] board) {
        Queue<int []> que = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'R') {
                    que.offer(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[] moveH = {1, -1, 0, 0};
        int[] moveW = {0, 0, -1, 1};

        int answer = 101 * 101;

        while (!que.isEmpty()){
            int[] tmp = que.poll();

            for(int i = 0; i < 4; i++){
                int tmpH = tmp[0] + moveH[i];
                int tmpW = tmp[1] + moveW[i];

                if(tmpH < 0 || tmpW < 0 || tmpH >= board.length || tmpW >= board[0].length() || board[tmpH].charAt(tmpW) == 'D') continue;

                while (tmpH >= 0 && tmpW >= 0 && tmpH < board.length && tmpW < board[0].length() && board[tmpH].charAt(tmpW) != 'D'){
                    tmpH += moveH[i];
                    tmpW += moveW[i];
                }

                tmpH -= moveH[i];
                tmpW -= moveW[i];

                if(visited[tmpH][tmpW]) continue;
                if (board[tmpH].charAt(tmpW) == 'G') return tmp[2] + 1;

                visited[tmpH][tmpW] = true;
                que.offer(new int[] {tmpH, tmpW, tmp[2] + 1});

            }
        }

        return -1;
    }
}