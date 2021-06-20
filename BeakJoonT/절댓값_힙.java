import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int first, second;
    
    public Pair(int first, int second) {
    	this.first = first;
    	this.second = second;
    }
    
    @Override
    public int compareTo(Pair p) {
        if(this.first > p.first) {
            return 1; // x에 대해서는 오름차순
        }
        else if(this.first == p.first) {
            if(this.second > p.second) { // y에 대해서는 오름차순
                return 1;
            }
        }
        return -1;
    }
}

public class 절댓값_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else {
					Pair pair = pq.poll();
					System.out.println(pair.second);
				}
			}
			else {
				if(n < 0) pq.add(new Pair(n * -1, n));
				else pq.add(new Pair(n, n));
			}
		}
	}
}