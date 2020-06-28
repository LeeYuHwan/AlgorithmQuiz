class Solution {
    public int[] solution(int N, int[] stages) {
		float[] result = new float[N];
		float stay_user = 0, dont_clear_user = 0;
		int[] answer = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < stages.length; j++) {
				if(i + 1 <= stages[j]) stay_user++;
				if(i + 1 == stages[j]) dont_clear_user++;
			}	
			if(stay_user != 0 && dont_clear_user != 0) result[i] = dont_clear_user / stay_user;
			else result[i] = 0;	
			stay_user = 0;
			dont_clear_user = 0;
			answer[i] = 0;
		}
		float max = -1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(max < result[j]) {
					max = result[j];
					answer[i] = j + 1;	
				}
			}
			result[answer[i] - 1] = -1;
			max = -1;
		}	
        return answer;
    }
}