#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

	int N = 0, K = 0;
	cin >> N >> K;

	vector<pair<int, int>> jv;
	for (int i = 0; i < N; i++) {
		int m = 0, v = 0;
		cin >> m >> v;
		jv.push_back(make_pair(m, v));
	}

	sort(jv.begin(), jv.end());

	vector<long> bv;
	for (int i = 0; i < K; i++) {
		int c = 0;
		cin >> c;
		bv.push_back(c);
	}
	
	sort(bv.begin(), bv.end());

	priority_queue<long> pq;
	int idx = 0;
	long long answer = 0;
	for (int i = 0; i < K; i++) {
		while (idx < N && jv[idx].first <= bv[i]) {
			pq.push(jv[idx].second);
			idx++;
		}
		if (!pq.empty()) {
			answer += pq.top();
			pq.pop();
		}
	}

	cout << answer;
}