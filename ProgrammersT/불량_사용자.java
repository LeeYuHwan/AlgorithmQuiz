import java.util.HashSet;
import java.util.LinkedHashSet;

class Solution {
    static HashSet<HashSet<String>> answerHs = new HashSet<>();

    static boolean check(HashSet<String> hs, String[] banned_id){
        int banIdIdx = 0;

        for (String hsId : hs) {
            String bannedId = banned_id[banIdIdx];

            if (hsId.length() != bannedId.length()) return false;
            for (int i = 0; i < bannedId.length(); i++) if(bannedId.charAt(i) != '*' && hsId.charAt(i) != bannedId.charAt(i)) return false;

            banIdIdx++;
        }


        return true;
    }

    static void dfs(HashSet<String> hs, String[] user_id, String[] banned_id){
        if(hs.size() == banned_id.length) {
            if(check(hs, banned_id)) answerHs.add(new HashSet<>(hs));
            return;
        }

        for (String userId : user_id) {
            if(!hs.contains(userId)) {
                hs.add(userId);
                dfs(hs, user_id, banned_id);
                hs.remove(userId);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        dfs(new LinkedHashSet<>(), user_id, banned_id);
        return answerHs.size();
    }
}