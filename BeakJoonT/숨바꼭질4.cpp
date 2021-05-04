#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int N = 0, K = 0;
int answer = 100001;
int idx = 100001;
vector<bool> visit(100001);
vector<int> route(100001);
vector<int> answerRoute;
void bfs() {
	queue<pair<int, int>> q;
	
	q.push(make_pair(0, N));
	while (!q.empty()) {
		int time = q.front().first;
		int n = q.front().second;
		q.pop();
			
		if (n == K) {
			idx = n;
			while (idx != N)
			{
				//cout << idx << endl;
				answerRoute.push_back(idx);
				idx = route[idx];
			}
			answerRoute.push_back(idx);
			answer = time;
			break;
		}
		if (n * 2 < 100001 && !visit[n * 2]) {
			q.push(make_pair(time + 1, n * 2));
			visit[n * 2] = true;
			route[n * 2] = n;
		}
		if (n + 1 < 100001 && !visit[n + 1]) {
			q.push(make_pair(time + 1, n + 1));
			visit[n + 1] = true;
			route[n + 1] = n;
		}
		if (n - 1 >= 0 && !visit[n - 1]) {
			q.push(make_pair(time + 1, n - 1));
			visit[n - 1] = true;
			route[n - 1] = n;
		}
	}
}

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	cin >> N >> K;
	if (N == K) {
		cout << 0 << '\n';
		cout << N;
	}
	else {
		bfs();
		cout << answer << '\n';
		for (int i = answerRoute.size() - 1; i >= 0; i--) {
			cout << answerRoute[i] << ' ';
		}
	}
}