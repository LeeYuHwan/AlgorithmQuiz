import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int bfs(String[] place, boolean[][] visited, int startH, int startW){
        int[] moveH = {1, -1, 0, 0};
        int[] moveW = {0, 0, -1, 1};

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startH, startW, 0});
        visited[startH][startW] = true;

        while (!que.isEmpty()){
            int[] tmp = que.poll();

            for (int i = 0; i < 4; i++){
                int tmpH = tmp[0] + moveH[i];
                int tmpW = tmp[1] + moveW[i];
                int cnt = tmp[2];

                if (tmpH < 0 || tmpW < 0 || tmpH >= place.length || tmpW >= place[0].length() || visited[tmpH][tmpW] || place[tmpH].charAt(tmpW) == 'X') continue;

                if (place[tmpH].charAt(tmpW) == 'P') {
                    if (cnt < 2) return 0;
                    cnt = 0;
                }
                else cnt += 1;

                visited[tmpH][tmpW] = true;
                que.offer(new int[] {tmpH, tmpW, cnt});
            }
        }

        return 1;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int idx = 0;

        for (String[] place : places) {
            boolean[][] visited = new boolean[place.length][place[0].length()];
            boolean sw = true;

            for (int i = 0; i < place.length; i++){
                for (int j = 0; j < place[0].length(); j++){
                    if (place[i].charAt(j) == 'P' && !visited[i][j]) {
                        answer[idx] = bfs(place, visited, i, j);
                        if (answer[idx] == 0) {
                            sw = false;
                            break;
                        }
                    }
                }

                if (sw) answer[idx] = 1;
                else break;
            }

            idx++;
        }


        return answer;
    }
}