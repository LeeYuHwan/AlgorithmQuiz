#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.second == b.second) return a.first > b.first;
	return a.second < b.second;
}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0, M = 0;

	cin >> N >> M;
	vector<pair<int, int>> v;
	int check = 0;
	for (int test = 0; test < N; test++) {
		int n = 0, m = 0;
		cin >> n >> m;

		v.push_back(make_pair(n, m));
		check += m;
	}

	sort(v.begin(), v.end(), cmp);

	int tmpN = 0, tmpM = 0, answer = check;
	bool sw = false;
	for (int i = 0; i < v.size(); i++) {
		tmpN += v[i].first;
		
		if(i > 0 && v[i - 1].second == v[i].second) tmpM += v[i].second;
		else tmpM = 0;

		if (tmpN >= M) {
			sw = true;
			answer = min(answer, tmpM + v[i].second);
		}
	}

	if (!sw) cout << -1;
	else cout << answer;	
}