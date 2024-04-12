import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static ArrayList<ArrayList<int []>> al = new ArrayList<>();
    static int[] visited;

    static int bfs(int startIdx, int[][] road, int K){
        Queue<int[]> que = new LinkedList<>(al.get(startIdx));

        for (int i = 2; i < visited.length; i++) visited[i] = Integer.MAX_VALUE;

        while (!que.isEmpty()){
            int[] tmp = que.poll();

            if(visited[tmp[1]] <= visited[tmp[0]] + tmp[2]) continue;

            visited[tmp[1]] = visited[tmp[0]] + tmp[2];
            que.addAll(al.get(tmp[1]));
        }

        int cnt = 1;
        for (int i = 2; i < visited.length; i++) if(visited[i] <= K) cnt++;

        return cnt;
    }

    public int solution(int N, int[][] road, int K) {
        visited = new int[N + 1];

        for (int i = 0; i <= N; i++) al.add(new ArrayList<>());

        for (int i = 0; i < road.length; i++){
            al.get(road[i][0]).add(new int[] {road[i][0], road[i][1], road[i][2]});
            al.get(road[i][1]).add(new int[] {road[i][1], road[i][0], road[i][2]});
        }

        int answer = bfs(1, road, K);
        return answer;
    }
}