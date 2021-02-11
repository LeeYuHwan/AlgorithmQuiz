#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n = 0, m = 0;
int move_w[4] = { 0, 0, -1, 1};
int move_h[4] = { -1, 1, 0, 0};
int check[100][100] = { 0 };
bool visit[100][100] = { false };
vector<int> answer;
vector<vector<char>> v;

void bfs(int h, int w) {
	visit[h][w] = true;

	queue<pair<int, int>> q;
	q.push(make_pair(h, w));

	while (!q.empty()) {
		int h = q.front().first;
		int w = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int tmp_w = w + move_w[i];
			int tmp_h = h + move_h[i];
			if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < m && tmp_h < n) {
				if (v[tmp_h][tmp_w] == '1' && visit[tmp_h][tmp_w] == false && check[tmp_h][tmp_w] == 0) {
					check[tmp_h][tmp_w] = check[h][w] + 1;
					visit[tmp_h][tmp_w] = true;
					q.push(make_pair(tmp_h, tmp_w));
				}
			}
		}
	}
}

int main()
{
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		vector<char> tmp;
		for (int j = 0; j < m; j++) {
			char num = '0';
			cin >> num;
			tmp.push_back(num);
		}
		v.push_back(tmp);
	}

	bfs(0, 0);

	cout << check[n - 1][m - 1] + 1;
}