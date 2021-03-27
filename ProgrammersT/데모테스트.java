class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        for(int i = 0; i < v.length; i++){ 
        	boolean sw = false;
        	int check = v[i][0];
            for(int j = 0; j < v.length; j++) {
            	if(check == v[j][0] && i != j) sw = true;
            }
            
            if(sw == false) answer[0] = check;
        }

        for(int i = 0; i < v.length; i++){ 
        	boolean sw = false;
        	int check = v[i][1];
            for(int j = 0; j < v.length; j++) {
            	if(check == v[j][1] && i != j) sw = true;
            }
            
            if(sw == false) answer[1] = check;
        }
        
        return answer;
    }
}