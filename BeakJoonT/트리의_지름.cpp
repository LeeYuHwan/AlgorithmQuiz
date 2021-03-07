#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

vector<int> tree[100001];
bool check[100001] = { false };

int topNode = 0;
int maxDist = 0;

void dfs(int idx, int cnt) {
	if (check[idx] == false) {
		check[idx] = true;

		if (maxDist < cnt) {
			maxDist = cnt;
			topNode = idx;
		}

		for (int i = 0; i < tree[idx].size(); i += 2) {
			int tmp = 0;
			dfs(tree[idx][i] - 1, tmp += cnt + tree[idx][i + 1]);
		}
	}	
}

int main()
{
	int v = 0;
	cin >> v;
	
	for (int i = 0; i < v; i++)
	{	
		int node = 0;
		cin >> node;
		while (1) {
			int tmp = 0;
			cin >> tmp;
			if (tmp == -1) break;

			tree[node - 1].push_back(tmp);
		}		
	}

	dfs(0, 0);
	memset(check, false, sizeof(check));
	dfs(topNode, 0);

	cout << maxDist << endl;
}