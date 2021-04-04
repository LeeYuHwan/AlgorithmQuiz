#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b)
{
	if (a.second == b.second) return a.first < b.first;
	return a.second < b.second;
}

int main() {
	vector<pair<int, int>> v;

	int N = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int n1 = 0, n2 = 0;
		cin >> n1 >> n2;
		v.push_back(make_pair(n1, n2));
	}

	sort(v.begin(), v.end(), cmp);

	int max = v[0].second;
	int answer = 1;
	for (int i = 1; i < N; i++) {
		if (max <= v[i].first) {
			answer++;
			max = v[i].second;
		}
	}

	cout << answer;
}