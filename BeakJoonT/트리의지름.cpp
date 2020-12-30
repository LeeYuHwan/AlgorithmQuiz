#include <iostream>
#include <vector>
#include <cstring>
using namespace std;
vector<pair<int, int>> g[10001];
bool check[10001];
int answer = 0;
int end_node = 0;

void dfs(int node, int weight) {
	if (check[node] != 1) {
		
		check[node] = 1;

		if (answer < weight) {
			answer = weight;
			end_node = node;
		}

		for (int i = 0; i < g[node].size(); i++) {
			dfs(g[node][i].first, weight + g[node][i].second);
		}
	}
}

int main(){
	int n = 0;
	cin >> n;

	

	for (int i = 1; i < n; i++) {
		int node1 = 0, node2 = 0, weight = 0;
		cin >> node1 >> node2 >> weight;

		g[node1].push_back(make_pair(node2, weight));
		g[node2].push_back(make_pair(node1, weight));
	}
	memset(check, false, sizeof(check));
	dfs(1, 0);
	memset(check, false, sizeof(check));
	dfs(end_node, 0);

	cout << answer;
}