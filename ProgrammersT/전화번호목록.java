import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        boolean answer = true;

        for(int i = 0; i < phone_book.length; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].contains(phone_book[i])) {
                    answer = false;
                    break;
                }
                else answer = true;
            }
            if(answer == false) break;
        }
        return answer;
    }
}