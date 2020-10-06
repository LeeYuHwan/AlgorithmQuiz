#include<iostream>
#include<vector>
#include<queue>
using namespace std;
int n = 0, m = 0, start = 0;
vector<vector<int>> g;
vector<bool> check;

void dfs(int idx) {
	if (check[idx]) return;
	check[idx] = true;
	cout << idx + 1 << " ";
	for (int i = 0; i < g[idx].size(); i++) {
		int tmp = g[idx][i];
		if (tmp == 1) {
			dfs(i);
		}
		
	}
}

void bfs(int idx) {

	queue<int> q;
	q.push(idx);
	check[idx] = true;
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		cout << x + 1 << " ";
		for (int i = 0; i < g[x].size(); i++) {
			int tmp = g[x][i];
			if (tmp == 1) {
				if (!check[i]) {
					q.push(i);
					check[i] = true;
				}
			}
			
		}
	}
}

int main(void)
{
	cin >> n >> m >> start;
	check.resize(n + 1);
	for (int i = 0; i < n; i++) {
		vector<int> g2(n);
		g.push_back(g2);
	}

	int e1 = 0, e2 = 0;
	for (int i = 0; i < m; i++) {
		cin >> e1 >> e2;
		g[e1 - 1][e2 - 1] = 1;
		g[e2 - 1][e1 - 1] = 1;
	}
	
	dfs(start - 1);
	for (int i = 0; i < n + 1; i++) {
		check[i] = false;
	}
	cout << endl;
	bfs(start - 1);
}