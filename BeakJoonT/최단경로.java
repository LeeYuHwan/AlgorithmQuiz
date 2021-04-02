import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class 최단경로 {		
    static int[] dijkstra(List<Node>[] li, int[] dist, int v, int start){
    	PriorityQueue<Node> queue = new PriorityQueue<>();
	    boolean[] check = new boolean[v + 1];
	    queue.add(new Node(start, 0));
	    dist[start] = 0;

	    while(!queue.isEmpty()){
	        Node curNode = queue.poll();
	        int cur = curNode.end;

	        if(check[cur] == true) continue;
	        check[cur] = true;

	        for(Node node : li[cur]){
	            if(dist[node.end] > dist[cur] + node.weight){
	                dist[node.end] = dist[cur] + node.weight;
	                queue.add(new Node(node.end, dist[node.end]));
	            }
	        }
	    }
	    
	    return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int INF = 100000000;
		List<Node>[] li = new ArrayList[V + 1];
	    int[] dist = new int[V + 1];
		
		int K = Integer.parseInt(reader.readLine());
		
		Arrays.fill(dist, INF);

        for(int i = 1; i <= V; i++){
            li[i] = new ArrayList<>();
        }
		
		for(int i = 0; i < E; i++) {
			StringTokenizer stw = new StringTokenizer(reader.readLine());
			int u = Integer.parseInt(stw.nextToken());
			int v = Integer.parseInt(stw.nextToken());
			int w = Integer.parseInt(stw.nextToken());
			
			li[u].add(new Node(v, w));
		}
			
		dist = dijkstra(li, dist, V, K);
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}	
}
