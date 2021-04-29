#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	vector<int> dp(5001);
	vector<int> pwd(5001);

	string s = "";
	cin >> s;

	for (int i = 0; i < s.length(); i++) {
		pwd[i + 1] = s[i] - '0';
	}

	if (s[0] == '0') cout << 0;
	else {
		dp[0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (pwd[i] >= 1 && pwd[i] <= 9) dp[i] = (dp[i] + dp[i - 1]) % 1000000;
			if (((pwd[i - 1] * 10) + pwd[i]) >= 10 && ((pwd[i - 1] * 10) + pwd[i]) <= 26) dp[i] = (dp[i] + dp[i - 2]) % 1000000;
		}
		cout << dp[s.length()] % 1000000;
	}
}