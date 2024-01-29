import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < players.length; i++) hm.put(players[i], i);

        for(String calling : callings){
            int rank = hm.get(calling);

            String tmp = players[rank - 1];
            players[rank - 1] = calling;
            players[rank] = tmp;

            hm.replace(calling, rank - 1);
            hm.replace(tmp, rank);
        }

        String[] answer = players;
        return answer;
    }
}