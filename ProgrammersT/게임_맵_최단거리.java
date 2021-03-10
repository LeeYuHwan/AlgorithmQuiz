import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int h;
    int w;
    Pair(int h, int w) {
        this.h = h;
        this.w = w;
    }
}

class Solution {
    public int solution(int[][] maps) {     
        int[] move_h = { -1, 1, 0, 0};
        int[] move_w = { 0, 0, -1, 1};        
        int[][] check = new int[101][101];
        boolean[][] visit = new boolean[101][101];
        boolean goal = false;

        Queue<Pair> q = new LinkedList<>();

        visit[0][0] = true;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int h = p.h;
            int w = p.w;

            for (int i = 0; i < 4; i++) {
                int tmp_w = w + move_w[i];
                int tmp_h = h + move_h[i];
                if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < maps[0].length && tmp_h < maps.length) {
                    if (maps[tmp_h][tmp_w] == 1 && visit[tmp_h][tmp_w] == false && check[tmp_h][tmp_w] == 0) {
                        check[tmp_h][tmp_w] = check[h][w] + 1;
                        visit[tmp_h][tmp_w] = true;
                        q.add(new Pair(tmp_h, tmp_w));
                        if(tmp_h == maps.length - 1 && tmp_w == maps[0].length - 1) goal = true;
                    }
                }
            }
        }

        if(goal == true) return check[maps.length - 1][maps[0].length - 1] + 1;
        return -1;
    }
}