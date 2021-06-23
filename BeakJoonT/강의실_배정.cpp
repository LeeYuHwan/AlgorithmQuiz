#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0;
	cin >> N;

	vector<pair<int, int>> v;
	for (int i = 0; i < N; i++) {
		int n1 = 0, n2 = 0;
		cin >> n1 >> n2;
		v.push_back(make_pair(n1, n2));
	}

	sort(v.begin(), v.end());

	priority_queue<int, vector<int>, greater<int>> pq;

	pq.push(v[0].second);
	for (int i = 1; i < N; i++) {
		if (pq.top() <= v[i].first) {
			pq.pop();
			pq.push(v[i].second);
		}
		else pq.push(v[i].second);
	}

	cout << pq.size();
}