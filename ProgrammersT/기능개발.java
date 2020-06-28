import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> prg_q = new LinkedList<Integer>();
		Queue<Integer> sp_q = new LinkedList<Integer>();
		Vector<Integer> result_v = new Vector();

		int day = 0, max = 0, result_pos = -1, result_value = 0;
		boolean sw = false;
		
		for(int i = 0; i < progresses.length; i++) {
			prg_q.offer(progresses[i]);
			sp_q.offer(speeds[i]);
		}
		
		for(int i = 0; i < progresses.length; i++) {
			for(int j = prg_q.peek() + sp_q.peek(); j <= 100; j += sp_q.peek()) {
				
				if((100 - prg_q.peek()) % sp_q.peek() == 0) day++;		
				else {
					sw = true;
					day++;
				}	
			}
			if(sw == true) {
				day++;
				sw = false;
			}
			if(day > max) {
				max = day;
				result_pos++;
				result_v.add(result_pos, 1);
				System.out.println("수행");
			}
			else{
				result_value = result_v.get(result_pos);
				result_value++;
				result_v.remove(result_pos);
				result_v.add(result_pos, result_value);
			}
			day = 0;
			prg_q.poll();
			sp_q.poll();
		}
		
		int[] result = new int[result_v.size()];
		
		for(int i = 0; i < result_v.size(); i++)
			result[i] = result_v.get(i);
        return result;
    }
}