#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(int a, int b) {
	return b < a;
}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

	int N = 0;	

	cin >> N;

	vector<int> v;

	for (int i = 0; i < N; i++) {
		int n = 0;
		cin >> n;

		v.push_back(n);
	}

	sort(v.begin(), v.end(), cmp);

	vector<long long> rect;
	for (int i = 0; i < N - 1; i++) {
		if (v[i] == v[i + 1]) {
			rect.push_back(v[i]);
			i++;
		}
		else if (v[i] - 1 == v[i + 1]) {
			rect.push_back(v[i] - 1);
			i++;
		}
	}

	long long answer = 0;

	for (int i = 0; i < rect.size(); i += 2) {
		if (i + 1 >= rect.size()) break;
		answer += rect[i] * rect[i + 1];
	}

	cout << answer;

}