#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	
	int dp[10001] = {0}, tmp[10001] = {0};
	int n = 0;

	cin >> n;

	int w = 0;
	for (int i = 1; i <= n; i++) {	
		cin >> w;
		tmp[i] = w;
	}
	
	dp[1] = tmp[1];
	dp[2] = tmp[1] + tmp[2];

	for (int i = 3; i <= n; i++) {
		dp[i] = max(tmp[i] + tmp[i - 1] + dp[i - 3], dp[i - 1]);
		dp[i] = max(dp[i], tmp[i] + dp[i - 2]);
	}

	cout << dp[n];
}