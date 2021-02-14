#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;
	vector<int> dp;
	vector<int> t;
	vector<int> p;

	for (int i = 0; i < n; i++) {
		int tNum = 0, pNum = 0;
		cin >> tNum >> pNum;
		t.push_back(tNum);
		p.push_back(pNum);
		dp.push_back(0);
	}
	t.push_back(0);
	p.push_back(0);
	dp.push_back(0);

	for (int i = t.size() - 2; i >= 0; i--) {
		if (i + t[i] > n) {
			dp[i] = dp[i + 1];
		}
		else {
			if (dp[i + 1] > p[i] + dp[i + t[i]]) dp[i] = dp[i + 1];
			else {
				dp[i] = p[i] + dp[i + t[i]];
			}
		}
	}

	cout << dp[0];
}