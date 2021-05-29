#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int T = 0;
	cin >> T;

	
	for (int i = 0; i < T; i++) {
		int n = 0;
		cin >> n;
		vector<vector<int>> v(2, vector<int>(100001, 0));
		vector<vector<int>> dp(2, vector<int>(100001, 0));

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= n; j++) {
				int num = 0;
				cin >> num;
				v[i][j] = num;
			}
		}

		dp[0][0] = 0;
		dp[1][0] = 0;
		dp[0][1] = v[0][1];
		dp[1][1] = v[1][1];
		for (int i = 2; i <= n; i++) {
			dp[0][i] = v[0][i] + max(dp[1][i - 1], dp[1][i - 2]);
			dp[1][i] = v[1][i] + max(dp[0][i - 1], dp[0][i - 2]);
		}

		cout << max(dp[0][n], dp[1][n]) << '\n';
	}
}