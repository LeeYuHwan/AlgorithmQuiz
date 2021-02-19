#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;

	vector<int> dp(n + 1);

	for (int i = 1; i <= n; i++) {
		dp[i] = i;
	}

	for (int i = 2; i <= n; i++) {
		for (int j = 2; (j * j) <= i; j++){
			dp[i] = min(dp[i], dp[i - (j * j)] + 1);
		}
	}

	cout << dp[n];
}