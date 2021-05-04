#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int N = 0, M = 0;
int answer = 0;
int move_h[4] = { -1, 1, 0, 0 };
int move_w[4] = { 0, 0, -1, 1 };

void bfs(vector<vector<int>> v) {
	queue<pair<int, int>> q;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (v[i][j] == 2) q.push(make_pair(i, j));
		}
	}

	while (!q.empty()) {
		int h = q.front().first;
		int w = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int tmp_w = w + move_w[i];
			int tmp_h = h + move_h[i];
			if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < M && tmp_h < N) {
				if (v[tmp_h][tmp_w] == 0) {
					q.push(make_pair(tmp_h, tmp_w));
					v[tmp_h][tmp_w] = 2;
				}
			}
		}
	}
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (v[i][j] == 0) cnt++;
		}
	}

	if (answer < cnt) answer = cnt;
}

void bruteDfs(vector<vector<int>> board, int h, int w, int idx) {
	board[h][w] = 1;
	if (idx == 3) {
		bfs(board);
	}
	else {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					bruteDfs(board, i, j, idx + 1);
				}
			}
		}
	}	
}

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	vector<vector<int>> board;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		vector<int> tmp;
		for (int j = 0; j < M; j++) {
			int n = 0;
			cin >> n;
			tmp.push_back(n);
		}
		board.push_back(tmp);
	}
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (board[i][j] == 0) {
				bruteDfs(board, i, j, 1);
			}
		}
	}

	cout << answer;
}