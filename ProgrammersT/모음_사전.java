import java.util.ArrayList;

class Solution {
    
    static ArrayList<String> al = new ArrayList<>();

    static void dfs(String str, int cnt){
        if(cnt > 5) return;
        al.add(str);
        for(int i = 0; i < 5; i++){
            dfs(str + "AEIOU".charAt(i), cnt + 1);
        }
    }
    
    public int solution(String word) {
        dfs("", 0);
        return al.indexOf(word);
    }
}