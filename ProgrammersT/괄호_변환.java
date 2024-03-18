class Solution {

    static boolean check(String u){
        int left = 0, right = 0;

        for (int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(') left++;
            else right++;

            if(left < right) {
                return false;
            }
        }

        return true;
    }

    static String reverse(String u){
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < u.length() - 1; i++){
            if(u.charAt(i) == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }

    static String dfs(String w){
        if(w.length() == 0) return w;

        int left = 0, right = 0;
        String u = "", v = "";

        for (int i = 0; i < w.length(); i++){
            if(w.charAt(i) == '(') left++;
            else right++;

            if(left == right) {
               u = w.substring(0, i + 1);
               v = w.substring(i + 1);
               break;
            }
        }

        if(check(u)) return u + dfs(v);
        return "(" + dfs(v) + ")" + reverse(u);
    }

    public String solution(String p) {
        String answer = dfs(p);
        return answer;
    }
}