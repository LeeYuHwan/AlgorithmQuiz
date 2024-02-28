import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int maxH = land.length;
        int maxW = land[0].length;

        int[] cnt = new int[land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) continue;

                HashSet<Integer> hs = new HashSet<>();
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{i, j});

                int sum = 1;
                land[i][j] = 0;
                hs.add(j);

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    for (int a = -1; a <= 1; a++) {
                        for (int b = -1; b <= 1; b++) {
                            if (((a^b)&1)!=1) continue;

                            int tmpH = cr+a;
                            int tmpW = cc+b;
                            if (tmpH < 0 || tmpW < 0 || tmpH >= maxH  || tmpW >= maxW || land[tmpH][tmpW] == 0) continue;

                            sum++;
                            land[tmpH][tmpW] = 0;

                            hs.add(tmpW);
                            q.add(new int[]{tmpH, tmpW});
                        }
                    }
                }

                for (int key : hs) {
                    cnt[key] += sum;
                }
            }
        }

        return Arrays.stream(cnt).max().getAsInt();
    }

}