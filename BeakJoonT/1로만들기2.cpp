#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	int n = 0;
	cin >> n;

	vector<pair<int, int>> dp(n + 1);
	for (int i = 2; i <= n; i++) {
		dp[i].first = dp[i - 1].first + 1;
		dp[i].second = 1;
		if (i % 3 == 0) {
			if (dp[i].first > dp[i / 3].first + 1) {
				dp[i].first = dp[i / 3].first + 1;
				dp[i].second = 3;
			}
			
		}
		if (i % 2 == 0) {
			if (dp[i].first > dp[i / 2].first + 1) {
				dp[i].first = dp[i / 2].first + 1;
				dp[i].second = 2;
			}
		}

	}

	cout << dp[n].first << '\n';
	int check = n, idx = n;
	cout << check << ' ';
	while (check != 1) {
		if (dp[idx].second == 3) {
			check /= 3;
			idx /= 3;
		}
		else if (dp[idx].second == 2) {
			check /= 2;
			idx /= 2;
		}
		else {
			check -= 1;
			idx -= 1;
		}
		cout << check << ' ';
	}
}