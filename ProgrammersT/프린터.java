import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
		int answer = 0;
		int count = 0;
		int index = 0;
		
		Integer[] tmp = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
		Arrays.sort(tmp, Collections.reverseOrder());
		
		for(int i = 0; i < tmp.length; i++) {			
			if(tmp[0] == priorities[i]) { index = i; break; }
		}
			
		for(int i = 0; i < tmp.length; i++) {
			for(int j = 0; j < tmp.length; j++) {			
				if(tmp[i] == priorities[index]) {
					priorities[index] = -1;
					count++;
					if(index == location) {
						answer = count;
						break;
					}
					break;
				}
				index++;
				index = index % tmp.length;
				
			}			
		}

		return answer;
    }
}