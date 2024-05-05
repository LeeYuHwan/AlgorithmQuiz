class Solution {
    static int answer;
    static boolean[] visited;

    static void dfs(String begin, String target, int idx, int count, String[] words){
        if(begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++){
            if(visited[i]) continue;

            int cnt = 0;
            for (int j = 0; j < words[i].length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) cnt++;
            }

            if(cnt == words[idx].length() - 1) {
                visited[i] = true;
                dfs(words[i], target, i, count + 1, words);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = words.length + 1;
        dfs(begin, target, 0, 0, words);
        
        if(answer == words.length + 1) answer = 0;
        return answer;
    }
}