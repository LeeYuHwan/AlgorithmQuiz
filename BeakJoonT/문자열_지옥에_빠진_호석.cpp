#include <iostream>
#include <vector>
#include <map>
using namespace std;

int N = 0, M = 0, K = 0;
int move_w[8] = { 0, 0, -1, 1, -1, 1, -1, 1 };
int move_h[8] = { -1, 1, 0, 0, -1, -1, 1, 1 };
vector<vector<char>> v;
map<string, int> m;
string check = "";

void dfs(int h, int w) {
	if (check.length() > 5) return;
	else {	
		if (m[check] > 0) m[check]++;

		for (int i = 0; i < 8; i++) {
			int tmp_h = h + move_h[i];
			int tmp_w = w + move_w[i];
			
			if (tmp_h < 0) tmp_h = N - 1;
			if (tmp_h > N - 1) tmp_h = 0;
			if (tmp_w < 0) tmp_w = M - 1;
			if (tmp_w > M - 1) tmp_w = 0;
		
			check += v[tmp_h][tmp_w];
			dfs(tmp_h, tmp_w);
			check.pop_back();
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	cin >> N >> M >> K;
		
	for (int i = 0; i < N; i++) {
		vector<char> tmp;
		string input = "";
		cin >> input;
		for (int j = 0; j < M; j++) {
			tmp.push_back(input[j]);
		}
		v.push_back(tmp);
	}

	vector<string> input;
	for (int i = 0; i < K; i++) {
		string tmp = "";
		cin >> tmp;
		input.push_back(tmp);
		m[tmp] = 1;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			check += v[i][j];
			dfs(i, j);
			check = "";
		}
	}

	for (int i = 0; i < input.size(); i++) {
		cout << m[input[i]] - 1 << '\n';
	}
}