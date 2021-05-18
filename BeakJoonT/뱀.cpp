#include <iostream>
#include <vector>
#include <queue>
#include <deque>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0;
	cin >> N;
	vector<vector<int>> g(N + 1, vector<int>(N + 1, 0));

	int K = 0;
	cin >> K;

	for (int i = 0; i < K; i++) {
		int h = 0, w = 0;
		cin >> h >> w;
		g[h][w] = 2;
	}

	int L = 0;
	cin >> L;

	priority_queue<pair<int, char>, vector<pair<int, char>>, greater<pair<int, char>>> pq;
	for (int i = 0; i < L; i++) {
		int s = 0;
		char w = '.';
		cin >> s >> w;
		pq.push(make_pair(s, w));
	}

	deque<pair<int, int>> dq;
	dq.push_back(make_pair(1, 1));
	g[1][1] = 1;

	char loc = 'u'; //up,down,left,right
	char sw = 'D'; //D오른쪽 L왼쪽
	int cnt = 0;

	while (1) {
		int h = dq.front().first;
		int w = dq.front().second;
		if (!pq.empty()) {
			int nextS = pq.top().first;
			char nextW = pq.top().second;
			if (nextS == cnt) {
				if (sw == 'D') {
					if (loc == 'u') loc = 'r';
					else if (loc == 'd') loc = 'l';
					else if (loc == 'l') loc = 'u';
					else loc = 'd';
				}
				else {
					if (loc == 'u') loc = 'l';
					else if (loc == 'd') loc = 'r';
					else if (loc == 'l') loc = 'd';
					else loc = 'u';
				}
				sw = nextW;
				pq.pop();
			}
		}

		if (sw == 'D') {
			if (loc == 'u') w++;
			else if (loc == 'd') w--;
			else if (loc == 'l') h--;
			else h++;
			cnt++;
			if ((h > N || w > N || h <= 0 || w <= 0) || g[h][w] == 1) {
				break;
			}
			else {
				if (g[h][w] != 2) {
					g[dq.back().first][dq.back().second] = 0;
					dq.pop_back();
				}
				g[h][w] = 1;
				dq.push_front(make_pair(h, w));
			}
		}
		else {
			if (loc == 'u') w--;
			else if (loc == 'd') w++;
			else if (loc == 'l') h++;
			else h--;
			cnt++;
			if ((h > N || w > N || h <= 0 || w <= 0) || g[h][w] == 1) {
				break;
			}
			else {
				if (g[h][w] != 2) {
					g[dq.back().first][dq.back().second] = 0;
					dq.pop_back();
				}
				g[h][w] = 1;
				dq.push_front(make_pair(h, w));
			}
		}
	}

	cout << cnt;
}