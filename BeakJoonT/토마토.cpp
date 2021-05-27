#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<vector<int>> v;
int M = 0, N = 0;
int move_h[4] = { 0, 0, 1, -1 };
int move_w[4] = { -1, 1, 0, 0 };
bool visit[1001][1001] = { false };
queue<pair<pair<int, int>, int>> q;
int answer = 0;

void bfs() {
	while (!q.empty()) {
		int h = q.front().first.first;
		int w = q.front().first.second;
		int time = q.front().second;
		answer = time;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int tmp_w = w + move_w[i];
			int tmp_h = h + move_h[i];
			if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < M && tmp_h < N) {
				if (v[tmp_h][tmp_w] == 0 && !visit[tmp_h][tmp_w]) {
					v[tmp_h][tmp_w] = 1;
					visit[tmp_h][tmp_w] = true;
					q.push(make_pair(make_pair(tmp_h, tmp_w), time + 1));
				}
			}
		}

	}
}

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	cin >> M >> N;

	for (int i = 0; i < N; i++) {
		vector<int> tmp;
		for (int j = 0; j < M; j++) {
			int n = 0;
			cin >> n;
			tmp.push_back(n);
		}
		v.push_back(tmp);
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (!visit[i][j] && v[i][j] == 1) {
				visit[i][j] = true;
				q.push(make_pair(make_pair(i, j), 0));
			}
		}
	}

	bfs();

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (v[i][j] == 0) answer = -1;
		}
	}

	cout << answer;
}