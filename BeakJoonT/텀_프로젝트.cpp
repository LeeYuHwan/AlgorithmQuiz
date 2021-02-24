#include <iostream>
#include <cstring>
using namespace std;
int cnt = 0;

int g[100001];
int visit[100001];
bool check[100001];

void dfs(int idx) {
	if (visit[idx] == -1 || check[idx]) return;
	if (visit[idx] == 0) visit[idx] = 1;
	else if (visit[idx] == 1) {
		check[idx] = true;
		cnt++;
	}
	dfs(g[idx]);
	visit[idx] = -1;
}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int testCase = 0;
	cin >> testCase;
	
	for (int t = 0; t < testCase; t++) {
		int n = 0;
		cin >> n;
	
		for (int i = 1; i <= n; i++) {		
			int tmp = 0;
			cin >> tmp;
			g[i] = tmp;
		}
		
		for (int i = 1; i <= n; i++) {
			if(visit[i] == 0) dfs(i);
		}		
		cout << n - cnt << endl;

		memset(g, 0, sizeof(g));
		memset(check, 0, sizeof(check));
		memset(visit, 0, sizeof(visit));
		cnt = 0;
	}
}