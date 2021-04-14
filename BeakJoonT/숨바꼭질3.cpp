#include <iostream>
#include <queue>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	
	int N = 0, K = 0;
	int max = 100001;
	cin >> N >> K;

	vector<bool> visit(max);
	pq.push(make_pair(0, N));
	
	while (!pq.empty()) {
		int time = pq.top().first;
		int dist = pq.top().second;
		pq.pop();

		visit[dist] = true;
		if (dist == K) {
			cout << time;
			break;
		}
		if (dist * 2 < max && !visit[dist * 2]) pq.push(make_pair(time, dist * 2));
		if (dist + 1 < max && !visit[dist + 1]) pq.push(make_pair(time + 1, dist + 1));
		if (dist - 1 >= 0 && !visit[dist - 1]) pq.push(make_pair(time + 1, dist - 1));	
	}
}