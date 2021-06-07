import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			int check = Integer.parseInt(st.nextToken());
			if(hm.get(check) == null) {
				al.add(i);
				hm.put(check, al);
			}
			else {
				al = hm.get(check);				
				al.add(i);
				hm.put(check, al);
			}	
		}
		
		int removeNum = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		int answer = 0;
		boolean first = false;
		q.add(-1);
		while(!q.isEmpty()) {
			int idx = q.poll();
			if(hm.get(idx) == null) answer++;
			else {
				boolean check = false;
				for(int i = 0; i < hm.get(idx).size(); i++) {
					if(hm.get(idx).get(i) != removeNum) {
						q.add(hm.get(idx).get(i));
						check = true;
					}
				}
				if(first && !check) answer++;
			}
			first = true;		
		}
		
		System.out.println(answer);		
	}
}
