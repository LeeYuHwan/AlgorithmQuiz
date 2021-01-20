#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    vector <vector<int>> oldT = triangle;
    vector<int> dp;
    int answer = triangle[0][0];

    if (triangle.size() > 1) {  
        for (int i = 0; i < triangle.size() - 1; i++) {     
            for (int j = 0; j < i + 1; j++) {
                dp.push_back(triangle[i][j]);
            }

            for (int j = 0; j < dp.size(); j++) {
                if (dp[j] + oldT[i + 1][j] > triangle[i + 1][j]) triangle[i + 1][j] = dp[j] + oldT[i + 1][j];
                if (dp[j] + oldT[i + 1][j + 1] > triangle[i + 1][j + 1]) triangle[i + 1][j + 1] = dp[j] + oldT[i + 1][j + 1];
            }

            dp.clear();
        }

        for (int i = 0; i < triangle[triangle.size() - 1].size(); i++) {
            if (triangle[triangle.size() - 1][i] > answer) answer = triangle[triangle.size() - 1][i];
        }
    }

    return answer;
}
