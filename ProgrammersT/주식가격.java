class Solution {
    public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int count = 0;
		
		for(int i = 0; i < prices.length; i++) {
			count = 0;
			if(i < prices.length - 1 ) {
				for(int j = i + 1; j < prices.length; j++) {
					count++;					
					if(prices[i] > prices[j]) break;
						
				}
				answer[i] = count;
			}
			
			else {
				answer[prices.length - 1] = 0;
			}
					
		}
        return answer;
    }
}