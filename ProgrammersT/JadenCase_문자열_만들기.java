class Solution {
    public String solution(String s) {    	    	   	
    	String answer = "";
    	
    	int check = 0;
    	for(int i = 0; i < s.length(); i++) {
    		String tmp = "";
    		if(s.charAt(i) != ' ') {   			
    			check++;
    		}
    		else {
    			check = 0;
    			answer += ' ';
    		}
    		if(check == 1) {
    			tmp += s.charAt(i);
    			answer += tmp.toUpperCase();
    		}
    		else if(check > 1){
    			tmp += s.charAt(i);
    			answer += tmp.toLowerCase();
    		}
    	}
    	
        return answer;
    }
}