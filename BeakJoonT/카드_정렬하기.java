import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 카드_정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		if(pq.size() == 1) System.out.println(0);
		else {		
			ArrayList<Integer> al = new ArrayList<Integer>();					
			al.add(pq.poll() + pq.poll());		
			int idx = 0;
			pq.add(al.get(0));
			
			while(pq.size() > 1) {
				al.add(pq.poll() + pq.poll());	
				idx++;
				pq.add(al.get(idx));
			}
			
			int answer = 0;
			for(int i = 0; i < al.size(); i++) {
				answer += al.get(i);
			}
			
			System.out.println(answer);
		}	
	}
}