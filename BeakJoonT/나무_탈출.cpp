#include <iostream>
#include <vector>
#include <map>
using namespace std;

int N = 0;
vector<bool> visit(500001);
vector<int> v[500001];
int answer = 0;

void dfs(int node, int cnt) {
	
	if (node != 1 && v[node].size() == 1) {
		answer += cnt;
		return;
	}

	for (int i = 0; i < v[node].size(); i++) {
		if (!visit[node]) {
			visit[node] = true;
			dfs(v[node][i], cnt + 1);
			visit[node] = false;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	cin >> N;

	for (int i = 1; i < N; i++) {
		int p = 0, c = 0;
		cin >> p >> c;
		v[p].push_back(c);
		v[c].push_back(p);
	}

	dfs(1, 0);
	if (answer % 2 == 1) cout << "Yes";
	else cout << "No";
}