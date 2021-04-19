#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int n = 0, m = 0;
	int x = 0, y = 0;
	int k = 0;

	cin >> n >> m >> y >> x >> k;

	vector<vector<int>> mv;
	for (int i = 0; i < n; i++) {
		vector<int> tmpV;
		for (int j = 0; j < m; j++) {
			int tmp = 0;
			cin >> tmp;

			tmpV.push_back(tmp);
		}
		mv.push_back(tmpV);
	}

	vector<int> w = { 1, -1, 0, 0 };
	vector<int> h = { 0, 0, -1, 1 };
	vector<int> dice(7);

	for (int i = 0; i < k; i++) {
		int dist = 0;
		cin >> dist;
		int nw = w[dist - 1] + x;
		int nh = h[dist - 1] + y;

		if (0 <= nw && nw < m && 0 <= nh && nh < n) {
			vector<int> tmpDice;
			for (int j = 0; j < dice.size(); j++) {
				tmpDice.push_back(dice[j]);
			}

			//동 서 북 남
			if (dist == 1) {
				dice[1] = tmpDice[4];
				dice[3] = tmpDice[1];
				dice[4] = tmpDice[6];
				dice[6] = tmpDice[3];
			}
			else if (dist == 2) {
				dice[1] = tmpDice[3];
				dice[3] = tmpDice[6];
				dice[4] = tmpDice[1];
				dice[6] = tmpDice[4];
			}
			else if (dist == 3) {
				dice[1] = tmpDice[5];
				dice[2] = tmpDice[1];
				dice[5] = tmpDice[6];
				dice[6] = tmpDice[2];
			}
			else {
				dice[1] = tmpDice[2];
				dice[2] = tmpDice[6];
				dice[5] = tmpDice[1];
				dice[6] = tmpDice[5];
			}

			if (mv[nh][nw] == 0) {
				mv[nh][nw] = dice[6];
			}
			else {
				dice[6] = mv[nh][nw];
				mv[nh][nw] = 0;
			}

			x = nw;
			y = nh;

			cout << dice[1] << '\n';
		}		
	}
}