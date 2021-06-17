#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<pair<int, int>> arr[2001];
int cnt[200001];
int answer[200001];
int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

	int n = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int c = 0, w = 0;
		cin >> c >> w;
		arr[w].push_back(make_pair(c, i));
	}
	
	int tmp = 0;
	for (int i = 1; i <= 2000; i++) {
		for (int j = 0; j < arr[i].size(); j++) {
			answer[arr[i][j].second] = tmp - cnt[arr[i][j].first];
		}
		for (int j = 0; j < arr[i].size(); j++) {
			cnt[arr[i][j].first] += i;
			tmp += i;
		}
	}
	for (int i = 0; i < n; i++) {
		cout << answer[i] << '\n';
	}
}