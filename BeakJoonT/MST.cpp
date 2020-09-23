#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>
using namespace std;

int getParent(int parent[], int x) {
	if (parent[x] == x) return x;
	return parent[x] = getParent(parent, parent[x]);
}

void unionParent(int* parent, int x, int y) {
	x = getParent(parent, x);
	y = getParent(parent, y);

	if (x < y) parent[y] = x;
	else parent[x] = y;
}

int findParent(int parent[], int x, int y) {
	x = getParent(parent, x);
	y = getParent(parent, y);

	if (x == y) return 1;
	return 0;
}

class Edge {
public:
	int node[2];
	int distance;
	Edge(int a, int b, int distance) {
		this->node[0] = a;
		this->node[1] = b;
		this->distance = distance;
	}
	bool operator < (Edge& edge) {
		return this->distance < edge.distance;
	}
};

int main() {
	int tmp = 0;	
	int v = 0, e = 0;
	int a = 0, b = 0;
	int turn = 0;
	int check_count = 0;
	bool check = true;
	// 정점 : a b 턴 : turn	
	cin >> v >> e >> turn;
	vector<Edge> graph;
	queue<pair<int, int>> check_q;
	

	for (int i = 0; i < e; i++) {
		cin >> a >> b;
		graph.push_back(Edge(a, b, i + 1));
		check_q.push(make_pair(a, b));
	}

	sort(graph.begin(), graph.end());

	int* parent = new int[v];
	for (int i = 0; i < turn; i++) {
		
		for (int j = 0; j < v; j++) {
			parent[j] = j;
		}
		for (int j = i; j < graph.size(); j++) {
			if (findParent(parent, graph[j].node[0] - 1, graph[j].node[1] - 1) == 0) {
				tmp += graph[j].distance;
				unionParent(parent, graph[j].node[0] - 1, graph[j].node[1] - 1);
				check_count++;
			}
		}

		if (check_count != v - 1) tmp = 0;
		cout << tmp << " ";
		tmp = 0;
		check_count = 0;		
	}
	delete[] parent;
}