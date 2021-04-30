#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int k = 0;
int max_w = 0, max_h = 0;
int move_h[4] = { -1, 1, 0, 0 };
int move_w[4] = { 0, 0, -1, 1 };
int knight_h[8] = {-1, -2, -2, -1, 1, 2, 2, 1};
int knight_w[8] = {-2, -1, 1, 2, -2, -1, 1, 2};
vector<vector<int>> v;
bool visit[201][201][31] = { false };
int answer = -1;
void bfs() {
	
	visit[0][0][0] = true;
	queue<pair<pair<int, int>,pair<int, int>>> q;
	q.push(make_pair(make_pair(0, 0), make_pair(0, 0)));

	while (!q.empty()) {
		int h = q.front().first.first;
		int w = q.front().first.second;
		int knight = q.front().second.first;
		int cnt = q.front().second.second;
		q.pop();

		if (h == (max_h - 1) && w == (max_w - 1)) {
			answer = cnt;
			break;
		}
		if (knight < k) {
			for (int i = 0; i < 8; i++) {
				int tmp_w = w + knight_w[i];
				int tmp_h = h + knight_h[i];
				if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < max_w && tmp_h < max_h) {
					if (v[tmp_h][tmp_w] == 0 && !visit[tmp_h][tmp_w][knight + 1]) {
						visit[tmp_h][tmp_w][knight + 1] = true;
						q.push(make_pair(make_pair(tmp_h, tmp_w), make_pair(knight + 1, cnt + 1)));
					}										
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			int tmp_w = w + move_w[i];
			int tmp_h = h + move_h[i];
			if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < max_w && tmp_h < max_h) {
				if (v[tmp_h][tmp_w] == 0 && !visit[tmp_h][tmp_w][knight]) {
					visit[tmp_h][tmp_w][knight] = true;
					q.push(make_pair(make_pair(tmp_h, tmp_w), make_pair(knight, cnt + 1)));
				}
			}
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	cin >> k;
	cin >> max_w >> max_h;

	for (int i = 0; i < max_h; i++) {
		vector<int> tmp;
		for (int j = 0; j < max_w; j++) {
			int board = 0;
			cin >> board;
			tmp.push_back(board);
		}
		v.push_back(tmp);
	}

	bfs();

	cout << answer;
}