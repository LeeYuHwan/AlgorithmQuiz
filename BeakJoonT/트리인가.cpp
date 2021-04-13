#include <iostream>
#include <queue>
#include <map>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	bool stop = false;
	int count = 0;
	while (stop != true) {
		count++;
		queue<int> q;
		vector<pair<int, int>> tmpV;
		map<int, pair<int, int>> rootCheck;
		int max = 0;
		bool result = true;
		bool zero = false;
		while (true) {			
			int u = 0, v = 0;
			cin >> u >> v;
			if (u < 0 && v < 0) {
				stop = true;
				break;
			}
			if (u == 0 && v == 0) {
				zero = true;
				break;
			}

			if (max < u) max = u;
			if (max < v) max = v;

			rootCheck[u].first++;
			rootCheck[v].second++;
			tmpV.push_back(make_pair(u, v));
		}
		if(tmpV.size() == 0 && zero) cout << "Case " << count << " is a tree." << '\n';
		else {
			if (stop == true) break;
			else {
				int root = 0;
				int rootCount = 0;
				vector<vector<int>> g(max + 1);
				vector<int> checkEmpty(max + 1);
				vector<bool> checkRoot(max + 1);
				for (int i = 0; i < tmpV.size(); i++) {
					g[tmpV[i].first].push_back(tmpV[i].second);
					checkEmpty[tmpV[i].first] = 1;
					checkEmpty[tmpV[i].second] = 1;
					if (!checkRoot[tmpV[i].first] && rootCheck[tmpV[i].first].first > 0 && rootCheck[tmpV[i].first].second == 0) {
						checkRoot[tmpV[i].first] = true;
						rootCount++;
						root = tmpV[i].first;
					}
				}
				if (rootCount != 1) cout << "Case " << count << " is not a tree." << '\n';
				else {
					vector<bool> check(max + 1);

					q.push(root);
					while (!q.empty()) {
						int node = q.front();
						q.pop();

						for (int i = 0; i < g[node].size(); i++) {
							if (check[g[node][i]]) {
								check[g[node][i]] = false;
								result = false;
								break;
							}
							if (!check[g[node][i]]) {
								check[g[node][i]] = true;
								q.push(g[node][i]);
							}
						}
					}

					if (result) {
						for (int i = 0; i < checkEmpty.size(); i++) {
							if (checkEmpty[i] == 1 && i != root) {
								if (!check[i]) result = false;
							}
						}
					}

					if (result) cout << "Case " << count << " is a tree." << '\n';
					else cout << "Case " << count << " is not a tree." << '\n';

				}
			}			
		}
	}	
}