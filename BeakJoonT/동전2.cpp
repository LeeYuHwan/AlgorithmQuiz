#include <iostream>
using namespace std;

int main()
{
	int n = 0, k = 0;
	cin >> n >> k;
	int coin[101] = {0};
	int dp[10001] = { 0 };

	for (int i = 1; i <= k; i++) {
		dp[i] = 100001;
	}

	for (int i = 1; i <= n; i++) {
		cin >> coin[i];
		for (int j = coin[i]; j <= k; j++) {
			if (dp[j] < dp[j - coin[i]] + 1) dp[j] = dp[j];
			else dp[j] = dp[j - coin[i]] + 1;
		}
	}

	if (dp[k] == 100001) cout << -1 << endl;
	else cout << dp[k];
}