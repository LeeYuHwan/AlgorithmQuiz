#include <string>
#include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    int dp[101][101] = {0};

    for (int i = 0; i < puddles.size(); i++) {
        dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
    }

    dp[0][0] = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (dp[i][j] == -1) {
                dp[i][j] = 0;
                continue;
            }
            if (i > 0) dp[i][j] += dp[i - 1][j] % 1000000007;
            if (j > 0) dp[i][j] += dp[i][j - 1] % 1000000007;

        }
    }

    answer = dp[n - 1][m - 1] % 1000000007;
    return answer;
}