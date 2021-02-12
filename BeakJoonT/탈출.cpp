#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n = 0, m = 0;
int move_w[4] = { 0, 0, -1, 1};
int move_h[4] = { -1, 1, 0, 0};
int waterCheck[51][51] = { 0 };
bool waterVisit[51][51] = { false };
int check[51][51] = { 0 };
bool visit[51][51] = { false };
vector<int> answer;
vector<vector<char>> v;
int endH = 0, endW = 0;

void waterBfs(int h, int w) {
	waterVisit[h][w] = true;

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
				if (v[tmp_h][tmp_w] == '.' && waterVisit[tmp_h][tmp_w] == false && waterCheck[tmp_h][tmp_w] == 0) {
					waterCheck[tmp_h][tmp_w] = waterCheck[h][w] + 1;
					waterVisit[tmp_h][tmp_w] = true;
					q.push(make_pair(tmp_h, tmp_w));
				}
			}
		}
	}
}

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
				if (v[tmp_h][tmp_w] == '.' || v[tmp_h][tmp_w] == 'D') {
					if (visit[tmp_h][tmp_w] == false && check[tmp_h][tmp_w] == 0) {
						if (check[h][w] + 1 < waterCheck[tmp_h][tmp_w] || waterCheck[tmp_h][tmp_w] == 0) {
							check[tmp_h][tmp_w] = check[h][w] + 1;
							visit[tmp_h][tmp_w] = true;
							q.push(make_pair(tmp_h, tmp_w));
						}
					}
				}				
			}
		}
	}
}

int main()
{
	cin >> n >> m;
	int startH = 0, startW = 0;
	bool waterSw = false;
	for (int i = 0; i < n; i++) {
		vector<char> tmp;
		for (int j = 0; j < m; j++) {
			char num = '.';
			cin >> num;
			if (num == 'S') {
				startH = i;
				startW = j;
				tmp.push_back('.');
			}
			else if (num == '*') {
				waterSw = true;
				tmp.push_back(num);
			}
			else if (num == 'D') {
				endH = i;
				endW = j;
				tmp.push_back(num);
			}
			else tmp.push_back(num);
			
		}
		v.push_back(tmp);
	}

	if (waterSw == true) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(v[i][j] == '*') waterBfs(i, j);
			}
		}
	}
	bfs(startH, startW);

	if (check[endH][endW] == 0) cout << "KAKTUS";
	else cout << check[endH][endW];
}