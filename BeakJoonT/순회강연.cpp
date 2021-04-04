#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b)
{
	if (a.first == b.first) return a.second > b.second;
	return a.first > b.first;
}

int main() {
	int n = 0;	
	cin >> n;

	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++) {
		int p = 0, d = 0;

		cin >> p >> d;
		v.push_back(make_pair(p, d));		
	}

	sort(v.begin(), v.end(), cmp);

	int answer = 0;
	bool check[10001] = {0};
	for (int i = 0; i < v.size(); i++) {
		for (int j = v[i].second; j >= 1; j--) {
			if (!check[j]) {
				check[j] = true;
				answer += v[i].first;
				break;
			}
		}
	}

	cout << answer;
}