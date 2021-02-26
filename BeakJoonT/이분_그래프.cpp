#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool sw = true;
vector<vector<int>> g;
vector<int> color;
string answer = "YES";

void bfs(int n) {
	queue<int> q;
	q.push(n);
	color[n] = 1;

	while (!q.empty()) {
		int node = q.front();
		q.pop();

		for (int i = 0; i < g[node].size(); i++) {
			if (color[g[node][i]] == 0 && color[node] == 1) {
				color[g[node][i]] = 2;
				q.push(g[node][i]);
			}
			else if (color[g[node][i]] == 0 && color[node] == 2) {
				color[g[node][i]] = 1;
				q.push(g[node][i]);
			}

			if (color[node] == color[g[node][i]]) {
				answer = "NO";
				sw = false;
				break;
			}
		}

		if (!sw) break;
	}
}

int main()
{
	
	
	int testCase = 0;
	cin >> testCase;

	for (int t = 0; t < testCase; t++) {
		int v = 0, e = 0;
		cin >> v >> e;
		
		g.resize(v + 1, vector<int>(0, 0));
		color.resize(v + 1, 0);
		for (int i = 0; i < e; i++) {
			int e1 = 0, e2 = 0;
			cin >> e1 >> e2;

			g[e1].push_back(e2);
			g[e2].push_back(e1);
			
		}

		answer = "YES";
		sw = true;
		
		for (int i = 0; i < g.size(); i++) {
			for (int j = 0; j < g[i].size(); j++) {
				if (color[g[i][j]] == 0) {
					bfs(g[i][j]);
				}
			}
		}
		
		g.clear();
		color.clear();
		cout << answer << endl;
	}
}