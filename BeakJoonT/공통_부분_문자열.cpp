#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	string s1 = "", s2 = "";	
	cin >> s1 >> s2;
	
	int answer = 0;
	vector<vector<int> > dp(4001, vector<int>(4001, 0));
	for (int i = 0; i < s1.length(); i++) {	
		for (int j = 0; j < s2.length(); j++) {
			if (i == 0 || j == 0) dp[i][j] = 1;
			else {
				if (s1[i] == s2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
				if (answer < dp[i][j]) answer = dp[i][j];
			}			
		}
	}

	cout << answer;
}