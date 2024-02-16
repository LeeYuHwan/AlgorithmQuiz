import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] moveH = {-1, 1, 0, 0};
    static int[] moveW = {0, 0, -1, 1};
    static boolean visited[][];

    static int bfs(int startH, int startW, String[] maps){
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[] {startH, startW});

        int sum = maps[startH].charAt(startW) - 48;

        while (!que.isEmpty()){
            int[] tmp = que.poll();

            for(int i = 0; i < 4; i++){
                int tmpH = tmp[0] + moveH[i];
                int tmpW = tmp[1] + moveW[i];

                if(tmpH < 0 || tmpW < 0 || tmpH >= maps.length || tmpW >= maps[0].length() || visited[tmpH][tmpW] || maps[tmpH].charAt(tmpW) == 'X') continue;

                visited[tmpH][tmpW] = true;
                sum += maps[tmpH].charAt(tmpW) - 48;

                que.add(new int[] {tmpH, tmpW});
            }
        }

        return sum;
    }

    public int[] solution(String[] maps) {

        visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < maps.length; i++){
            int sum = 0;
            for (int j = 0; j < maps[i].length(); j++){
                if (maps[i].charAt(j) != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    sum = bfs(i, j, maps);

                    if(sum != 0) al.add(sum);
                }
            }
        }


        if (al.size() == 0) return new int[] {-1};
        Integer[] tmpArr = al.toArray(new Integer[al.size()]);
        int[] answer = Arrays.stream(tmpArr).mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}