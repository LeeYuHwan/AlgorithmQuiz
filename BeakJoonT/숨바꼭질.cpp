#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int N = 0, K = 0;
int answer = 100001;
vector<bool> visit(100001);
void bfs() {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push(make_pair(0, N));

	while (!pq.empty()) {
		int time = pq.top().first;
		int n = pq.top().second;
		pq.pop();

		visit[n] = true;
		if (n == K) {
			answer = time;
			break;
		}
		if (n * 2 < 100001 && !visit[n * 2]) pq.push(make_pair(time + 1, n * 2));
		if (n + 1 < 100001 && !visit[n + 1]) pq.push(make_pair(time + 1, n + 1));
		if (n - 1 >= 0 && !visit[n - 1]) pq.push(make_pair(time + 1, n - 1));
	}
}

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	cin >> N >> K;
	if (N == K) cout << 0;
	else {
		bfs();
		cout << answer;
	}
}