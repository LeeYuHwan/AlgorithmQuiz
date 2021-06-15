import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair2 implements Comparable<Pair2> {
    int first, second;
    
    public Pair2(int first, int second) {
    	this.first = first;
    	this.second = second;
    }
    
    @Override
    public int compareTo(Pair2 p) {
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

public class 흙길_보수하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		ArrayList<Pair2> al = new ArrayList<Pair2>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			al.add(new Pair2(n1, n2));
		}
		
		Collections.sort(al);
		
		int answer = 0, loc = 0;
		for(int i = 0; i < N; i++) {
			Pair2 p = al.get(i);
			
			if(p.first < (loc + 1)) p.first = loc + 1;
			if(p.first > p.second) continue;
			
			int tmp = (p.second - p.first) % L;
			int check = L;
			if(tmp > 0) {
				answer += ((p.second - p.first) / L) + 1;
				check *= ((p.second - p.first) / L) + 1;
			}
			else {
				answer += (p.second - p.first) / L;
				check *= (p.second - p.first) / L;
			}
			
			loc = (p.second - 1) + (check - (p.second - p.first));
		}
		
		System.out.println(answer);
	}
}