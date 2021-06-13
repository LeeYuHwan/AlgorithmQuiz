import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째_큰_수 {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		boolean first = true;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int data = Integer.parseInt(st.nextToken());
				if(first) pq.add(data);
				else {
					if(pq.peek() < data) {				
						pq.add(data);
						pq.poll();
					}
				}
			}
			first = false;
		}
		System.out.println(pq.peek());
	}
}