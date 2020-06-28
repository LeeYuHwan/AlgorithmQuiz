class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] check = new int[n];
		int count_lost = 0, count_reserve = 0;
		int answer = 0;
		
		for(int i = 0; i < check.length; i++) {
			check[i] = 1;
		}
			
		for(int i = 0; i < reserve.length; i++) {
			check[reserve[i] - 1] = 2;
		}
		
		for(int i = 0; i < lost.length; i++) {
			check[lost[i] - 1] -= 1;
		}
		
		
		for(int i = 0; i < n; i++) {
			if(check[i] == 0) {
				if(i == 0) {
					if(check[i + 1] == 2) {
						check[i] = 1;
						check[i + 1] -= 1;
					}
				}
				else if (i == n - 1) {
					if(check[i - 1] == 2) {
						check[i] = 1;
						check[i - 1] -= 1;
					}
				}
				else {
					if(check[i + 1] == 2) {
						check[i] = 1;
						check[i + 1] -= 1;
					}
					else if(check[i - 1] == 2) {
						check[i] = 1;
						check[i - 1] -= 1;
					}
				}
			}
			
			if(check[i] != 0) answer++;
 
		}
        return answer;
    }
}