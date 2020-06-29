import java.util.ArrayList;
class Solution {
    public int solution(int[] nums) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
		int answer = 0;
		int max = nums.length / 2;
		
        for(int i = 0; i < nums.length; i++) {
        	if(!numbers.contains(nums[i])) {
        		numbers.add(nums[i]);
        	}       	
        }
        
        if(numbers.size() > max) answer = max;
        else answer = numbers.size();
        
        return answer;
    }
}