#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

//https://www.codetree.ai/missions/4/problems/grid-anti-fill/description 격자 반대로 채우기

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	
	int N = 0;

	bool sw = true;

	cin >> N;

	vector<vector<int>> v;
	for (int i = 0; i < N; i++) {
		vector<int> tmp;
		for (int j = 0; j < N; j++) {
			tmp.push_back(0);
		}
		v.push_back(tmp);
	}
	
	int j = N - 1;
	int cnt = 1;
	for (int idx = 0; idx < N; idx++) {
		int i = 0;

		if (sw) i = N - 1;
		else i = 0;

		for (int idx2 = 0; idx2 < N; idx2++) {
			if (sw) {
				v[i--][j] = cnt;
			}
			else {
				v[i++][j] = cnt;
			}
			cnt++;
		}
		if (sw) sw = false;
		else sw = true;

		j--;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << v[i][j] << ' ';
		}
		cout << '\n';
	}

}