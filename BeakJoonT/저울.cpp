#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	vector<int> v;

	int N = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int num = 0;
		cin >> num;
		v.push_back(num);
	}

	sort(v.begin(), v.end());

	int sum = 0;
	for (int i = 0; i < N; i++) {
		if (v[i] > sum + 1) break;
		sum += v[i];
	}
	cout << sum + 1;
}