import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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

public class 신입_사원 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			List<Pair> al = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				al.add(new Pair(n1, n2));
			}
			Collections.sort(al);
			
			Pair pair = al.get(0);
			int minFirst = pair.first;
			int minSecond = pair.second;
			int answer = 1;
			
			for(int i = 1; i < N; i++) {
				Pair pair2 = al.get(i);
				if(minFirst > pair2.first) {
					minFirst = pair2.first;
					answer++;
				}
				else if(minSecond > pair2.second) {
					minSecond = pair2.second;
					answer++;
				}				
			}
			
			System.out.println(answer);
		}		
	}
}