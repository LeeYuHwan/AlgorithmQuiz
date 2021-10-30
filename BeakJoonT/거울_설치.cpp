#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define MAX 2000000000
using namespace std;

int n = 0;

int move_w[4] = { 1, 0, -1, 0 };
int move_h[4] = { 0, 1, 0, -1 };
vector < vector<char>> v;
int check[50][50][4];
int answer = MAX;


void bfs(int startH, int startW) {
	queue<pair<pair<int, int>, int>> q;
	
	for (int i = 0; i < 4; i++) {
		q.push(make_pair(make_pair(startH, startW), i));
		check[startH][startW][i] = 1;
	}
	
	while (!q.empty()) {
		int h = q.front().first.first;
		int w = q.front().first.second;
		int dir = q.front().second;
		q.pop();

		int tmp_w = w + move_w[dir];
		int tmp_h = h + move_h[dir];

		if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < n && tmp_h < n && v[tmp_h][tmp_w] != '*') {
			if (v[tmp_h][tmp_w] == '!') {
				if (check[h][w][dir] < check[tmp_h][tmp_w][dir]) {
					check[tmp_h][tmp_w][dir] = check[h][w][dir];
					q.push(make_pair(make_pair(tmp_h, tmp_w), dir));
				}

				for (int i = 1; i < 4; i += 2) {
					int tmpDir = (dir + i) % 4;
					if (check[h][w][dir] + 1 < check[tmp_h][tmp_w][tmpDir]) {
						check[tmp_h][tmp_w][tmpDir] = check[h][w][dir] + 1;
						q.push(make_pair(make_pair(tmp_h, tmp_w), tmpDir));
					}
				}
			}
			else if (v[tmp_h][tmp_w] == '.' || v[tmp_h][tmp_w] == '#') {
				if (check[h][w][dir] < check[tmp_h][tmp_w][dir] || check[tmp_h][tmp_w][dir] == 0) {
					check[tmp_h][tmp_w][dir] = check[h][w][dir];
					q.push(make_pair(make_pair(tmp_h, tmp_w), dir));
				}
			}
		}

		
	}

}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

	cin >> n;

	int startH = 0, startW = 0, endH = 0, endW = 0;

	bool sw = false;
	for (int i = 0; i < n; i++) {
		vector<char> tmp;
		for (int j = 0; j < n; j++) {
			char room;
			cin >> room;
			
			if (!sw && room == '#') {
				startH = i;
				startW = j;

				sw = true;
			}
			if (sw && room == '#') {
				endH = i;
				endW = j;
			}

			for (int z = 0; z < 4; z++) check[i][j][z] = MAX;		

			tmp.push_back(room);
		}

		v.push_back(tmp);
	}

	bfs(startH, startW);

	for (int i = 0; i < 4; i++){
		if (check[endH][endW][i] != 0) answer = min(answer, check[endH][endW][i]);
	}

	cout << answer - 1;
}