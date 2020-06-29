import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> al = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<>();
        String[] check = new String[3];

        for(int i = 0; i < record.length; i++) {
            StringTokenizer tokens = new StringTokenizer( record[i], " " );

            for( int x = 0; tokens.hasMoreElements(); x++ ){ 
                check[x] = tokens.nextToken(); 
            }

            if(check[0].equals("Enter") || check[0].equals("Change")) {
                map.put(check[1], check[2]);
            }

        }

        for(int i = 0; i < record.length; i++) {
            StringTokenizer tokens = new StringTokenizer( record[i], " " );

            for( int x = 0; tokens.hasMoreElements(); x++ ){ 
                check[x] = tokens.nextToken(); 
            }

            if(check[0].equals("Enter")) {
                al.add(map.get(check[1]) + "님이 들어왔습니다.");
            }
            else if(check[0].equals("Leave")) {
                al.add(map.get(check[1]) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[al.size()];

        for(int i = 0; i < al.size(); i ++) {
            answer[i] = al.get(i);              
        }
        return answer;
    }
}