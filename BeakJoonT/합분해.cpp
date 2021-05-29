#include <iostream>
#include <vector>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int N = 0, K = 0;
	cin >> N >> K;

	vector<vector<long long>> dp(201, vector<long long>(201, 0));
	for (int i = 0; i <= N; i++) {
		dp[1][i] = 1;
	}

	for (int i = 2; i <= K; i++) {
		for (int j = 0; j <= N; j++) {
			for (int z = 0; z <= j; z++) {
				dp[i][j] += dp[i - 1][z];
			}
			dp[i][j] %= 1000000000;
		}
	}

	cout << dp[K][N];
}