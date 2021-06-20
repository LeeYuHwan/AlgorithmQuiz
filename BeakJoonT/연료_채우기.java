import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Fuel implements Comparable<Fuel>{
	int loc;
	int oil;
	public Fuel(int loc, int oil) {
		this.loc = loc;
		this.oil = oil;
	}
	
	@Override
    public int compareTo(Fuel p) {
        if(this.loc > p.loc) {
            return 1; // x에 대해서는 오름차순
        }
        else if(this.loc == p.loc) {
            if(this.oil > p.oil) { // y에 대해서는 오름차순
                return 1;
            }
        }
        return -1;
    }
}

public class 연료_채우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Fuel> al = new ArrayList<Fuel>();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			al.add(new Fuel(n1, n2));
		}
		st = new StringTokenizer(br.readLine());
		int goal = Integer.parseInt(st.nextToken());
		int curOil = Integer.parseInt(st.nextToken());
		
		Collections.sort(al);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int idx = 0, answer = 0;
		boolean sw = true;
		while(curOil < goal) {
			while(idx < N && curOil >= al.get(idx).loc) {
				pq.add(al.get(idx).oil);
				idx++;
			}
			
			if(pq.isEmpty()) {
				sw = false;
				break;
			}
			
			curOil += pq.poll();
			answer++;
		}
		
		if(sw) System.out.println(answer);
		else System.out.println(-1);
	}
}