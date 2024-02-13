import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int h = 0, w = 0, answer = 0;
    static int[] moveH = {-1, 1, 0, 0};
    static int[] moveW = {0, 0, -1, 1};
    static boolean sw = true;

    static int bfs(int startH, int startW, char goal, String[] maps, boolean[][] visited){

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {startH, startW, 0});

        while (!que.isEmpty()){
            int tmp[] = que.poll();

            for(int i = 0; i < 4; i++){
                int tmpH = tmp[0] + moveH[i];
                int tmpW = tmp[1] + moveW[i];
                int cnt = tmp[2] + 1;

                if (tmpH < 0 || tmpW < 0 || tmpH >= maps.length || tmpW >= maps[i].length() || visited[tmpH][tmpW] || maps[tmpH].charAt(tmpW) == 'X') continue;

                if (maps[tmpH].charAt(tmpW) == goal) {
                    h = tmpH;
                    w = tmpW;

                    return cnt;
                }

                visited[tmpH][tmpW] = true;
                que.add(new int[] {tmpH, tmpW, cnt});

            }
        }

        sw = false;
        return -1;
    }

    static int solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) for (int j = 0; j < maps[i].length(); j++) if(maps[i].charAt(j) == 'S') { h = i; w = j; }

        answer += bfs(h, w, 'L', maps, visited);

        visited = new boolean[maps.length][maps[0].length()];
        answer += bfs(h, w, 'E', maps, visited);

        if (!sw) answer = -1;
        return answer;
    }
}