#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int move_h[8] = { -1, -2, -1, -2, 2, 1, 2, 1};
int move_w[8] = { -2, -1, 2, 1, -1, -2, 1, 2};

int bfs(int I, vector<vector<int>> board, int startH, int startW, int endH, int endW) {
	int check[301][301] = { 0 };
	bool visit[301][301] = { false };
	visit[startH][startW] = true;

	queue<pair<int, int>> q;
	q.push(make_pair(startH, startW));

	while (!q.empty()) {
		int h = q.front().first;
		int w = q.front().second;
		q.pop();
		for (int i = 0; i < 8; i++) {
			int tmp_w = w + move_w[i];
			int tmp_h = h + move_h[i];
			if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < I && tmp_h < I) {
				if (board[tmp_h][tmp_w] == 0 && visit[tmp_h][tmp_w] == false && check[tmp_h][tmp_w] == 0) {					
					check[tmp_h][tmp_w] = check[h][w] + 1;
					visit[tmp_h][tmp_w] = true;
					q.push(make_pair(tmp_h, tmp_w));
				}
			}
		}
	}

	return check[endH][endW];
}

int main()
{
	int t = 0;
	cin >> t;

	for (int testCase = 0; testCase < t; testCase++) {
		int I = 0;
		cin >> I;

		vector<vector<int>> board(I, vector<int>(I, 0));

		int startH = 0, startW = 0;
		int endH = 0, endW = 0;

		cin >> startH >> startW;
		cin >> endH >> endW;

		int answer = bfs(I, board, startH, startW, endH, endW);
		cout << answer << endl;
	}
}