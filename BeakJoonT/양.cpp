#include <iostream>
#include <vector>
#include <queue>
using namespace std;

queue<pair<int, int>> q;
vector<vector<char>> fence;
int r = 0, c = 0;
int move_w[4] = { 0, 0, -1, 1 };
int move_h[4] = { -1, 1, 0, 0 };
int ans_o = 0, ans_v = 0;

void bfs(int oNum, int vNum) {
	int o = 0 + oNum;
	int v = 0 + vNum;

	while (!q.empty()) {
		int h = q.front().first;
		int w = q.front().second;

		q.pop();
		for (int i = 0; i < 4; i++) {
			int tmp_w = w + move_w[i];
			int tmp_h = h + move_h[i];
			if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < c && tmp_h < r) {
				if (fence[tmp_h][tmp_w] == 'o') {
					o++;
					fence[tmp_h][tmp_w] = '-';					
					q.push(make_pair(tmp_h, tmp_w));
				}
				else if (fence[tmp_h][tmp_w] == 'v') {
					v++;
					fence[tmp_h][tmp_w] = '-';					
					q.push(make_pair(tmp_h, tmp_w));
				}
				else if (fence[tmp_h][tmp_w] == '.') {
					fence[tmp_h][tmp_w] = '-';
					q.push(make_pair(tmp_h, tmp_w));
				}
			}
		}
	}

	if (o > v) ans_o += o;
	else ans_v += v;	
}

int main() {
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	cin >> r >> c;
		
	for (int i = 0; i < r; i++) {
		vector<char> tmp;
		for (int j = 0; j < c; j++) {
			char x = ' ';
			cin >> x;

			tmp.push_back(x);
		}
		fence.push_back(tmp);
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (fence[i][j] == '.') {
				fence[i][j] = '-';
				q.push(make_pair(i, j));
				bfs(0, 0);
			}
			else if (fence[i][j] == 'o') {
				fence[i][j] = '-';
				q.push(make_pair(i, j));
				bfs(1, 0);
			}
			else if (fence[i][j] == 'v') {
				fence[i][j] = '-';
				q.push(make_pair(i, j));
				bfs(0, 1);
			}
		}
	}

	cout << ans_o << " " << ans_v;
}