#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0, M = 0;

	cin >> N >> M;

	vector<int> v[32001];
	int inDegree[32001] = { 0 };
	for (int i = 1; i <= M; i++) {
		int a = 0, b = 0;
		cin >> a >> b;
		v[a].push_back(b);
		inDegree[b]++;
	}

	int answer[32001] = { 0 };
	priority_queue<int, vector<int>, greater<int>> pq;

	for (int i = 1; i <= N; i++) {
		if (inDegree[i] == 0) pq.push(i);
	}

	int idx = 1;
	while (!pq.empty() && idx <= N) {
		int tmp = pq.top();
		pq.pop();

		answer[idx] = tmp;
		
		for (int i = 0; i < v[tmp].size(); i++) {
			int data = v[tmp][i];
			if (--inDegree[data] == 0) pq.push(data);
		}

		idx++;
	}

	for (int i = 1; i <= N; i++) {
		cout << answer[i] << ' ';
	}
}