#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0, C = 0;
	cin >> N >> C;

	vector<int> v;

	for (int i = 0; i < N; i++) {
		int n = 0;
		cin >> n;

		v.push_back(n);
	}

	sort(v.begin(), v.end());

	int left = 1, right = v[v.size() - 1] - v[0];
	int answer = 0;
	while (left <= right) {
		int mid = (left + right) / 2;
		int check = 0;
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			if ((v[i] - v[check]) >= mid) {
				check = i;
				cnt++;
			}
		}

		if (cnt >= C) {
			if (answer < mid) answer = mid;
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}

	cout << answer;
}