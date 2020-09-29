#include<iostream>
#include<vector>
using namespace std;

int main()
{
	int n = 0;
	long k = 0;
	long answer = 0;
	vector<int> a;

	cin >> n >> k;

	int tmp = 0;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		a.push_back(tmp);
	}

	for (int i = n - 1; i >= 0; i--) {
		answer += k / a[i];
		k %= a[i];
	}

	cout << answer;
}