#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n = 0, k = 0;
	cin >> n >> k;
	vector<vector<int>> dp(n + 1, vector<int>(k + 1, 0));
	vector<int> v(n + 1);
	vector<int> w(n + 1);
	for (int i = 1; i <= n; i++) {
		cin >> w[i] >> v[i];
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			if (j >= w[i]) dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
			else dp[i][j] = dp[i - 1][j];
		}
	}

	cout << dp[n][k] << " ";
}